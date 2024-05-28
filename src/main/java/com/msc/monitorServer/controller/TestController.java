package com.msc.monitorServer.controller;

import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.service.ServerMessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@CrossOrigin
@Validated
public class TestController {

    private final ServerMessageService serverMessageService;
    @GetMapping("/getByEmai")
    public String getByEmai(@RequestParam @Valid @Email(message = "Email should be valid") @NotBlank(message = "Email is mandatory") String email){
        return serverMessageService.getByEmai(email);
    }

    @GetMapping("/getByMobile")
    public List<ServerMessageDto> getByMobile(@RequestParam String mobile){
        return serverMessageService.getByMobile(mobile);
    }
}
