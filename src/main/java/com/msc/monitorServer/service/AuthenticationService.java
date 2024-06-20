package com.msc.monitorServer.service;

import com.msc.monitorServer.model.dto.AppUserDto;
import com.msc.monitorServer.model.dto.AuthenticationDto;
import com.msc.monitorServer.model.dto.LoginDetailsDto;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    AuthenticationDto register(AppUserDto appUser);
    AuthenticationDto authenticate(LoginDetailsDto loginDetailsDto);
    AuthenticationDto refreshToken(HttpServletRequest request);

}
