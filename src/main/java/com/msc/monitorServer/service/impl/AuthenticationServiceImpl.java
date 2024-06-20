package com.msc.monitorServer.service.impl;

import com.msc.monitorServer.config.security.JwtServiceConfig;
import com.msc.monitorServer.model.dto.AppUserDto;
import com.msc.monitorServer.model.dto.AuthenticationDto;
import com.msc.monitorServer.model.dto.LoginDetailsDto;
import com.msc.monitorServer.model.entity.AppUserEntity;
import com.msc.monitorServer.repository.AppUserRepository;
import com.msc.monitorServer.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceConfig jwtServiceConfig;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationDto register(AppUserDto appUser) {
        AuthenticationDto authenticationDto = null;
        Map<String,String> errorDetail = new HashMap();
        try{
            AppUserEntity user = AppUserEntity.builder()
                    .username(appUser.getUserName())
                    .password(passwordEncoder.encode(appUser.getPassword()))
                    .userRole(appUser.getUserRole())
                    .build();
            appUserRepository.save(user);
            authenticationDto = AuthenticationDto.builder()
                    .accessToken(jwtServiceConfig.generateAccessToken(user))
                    .refreshToken(jwtServiceConfig.generateRefreshToken(user))
                    .build();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return authenticationDto;
    }

    @Override
    public AuthenticationDto authenticate(LoginDetailsDto loginDetailsDto) {
        AuthenticationDto authenticationDto = null;
        Map<String,String> errorDetail = new HashMap();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDetailsDto.getUserName(),loginDetailsDto.getPassword()));
            AppUserEntity user = appUserRepository.findByUsername(loginDetailsDto.getUserName()).orElseThrow();
            authenticationDto = AuthenticationDto.builder()
                    .accessToken(jwtServiceConfig.generateAccessToken(user))
                    .refreshToken(jwtServiceConfig.generateRefreshToken(user))
                    .build();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return authenticationDto;
    }

    @Override
    public AuthenticationDto refreshToken(HttpServletRequest request) {
        AuthenticationDto authenticationDto = null;
        Map<String,String> errorDetail = new HashMap();
        try {
            final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            final String refreshToken;
            final String userName;
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                refreshToken = authHeader.substring(7);
                userName = jwtServiceConfig.extractUserName(refreshToken);
                if (userName != null) {
                    AppUserEntity user = this.appUserRepository.findByUsername(userName)
                            .orElseThrow();
                    if (jwtServiceConfig.isJwtTokenValid(refreshToken, user)) {
                        String accessToken = jwtServiceConfig.generateAccessToken(user);
                        authenticationDto = AuthenticationDto.builder()
                                .accessToken(accessToken)
                                .refreshToken(refreshToken)
                                .build();
                    }
                }
            }
        }catch (Exception ex){

        }
        return authenticationDto;
    }
}
