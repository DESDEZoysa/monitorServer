package com.msc.monitorServer.controller;

import aj.org.objectweb.asm.Handle;
import com.msc.monitorServer.model.dto.AppUserDto;
import com.msc.monitorServer.model.dto.AuthenticationDto;
import com.msc.monitorServer.model.dto.LoginDetailsDto;
import com.msc.monitorServer.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
@Tag(name = "Authenticate")
@Hidden
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationDto register(@RequestBody AppUserDto appUser) {
        return authenticationService.register(appUser);
    }
    @PostMapping("/login")
    @Operation(summary = "can be get Bearer token for the user by providing correct username and password")
    public HashMap authenticate(@RequestBody LoginDetailsDto loginDetailsDto) {
        HashMap map = new HashMap<>();
        map.put("data",authenticationService.authenticate(loginDetailsDto));
        map.put("error","");
        return map;
    }

//    @GetMapping("/refreshToken")
//    public AuthenticationDto refreshToken(HttpServletRequest request) {
//        return authenticationService.refreshToken(request);
//    }
}
