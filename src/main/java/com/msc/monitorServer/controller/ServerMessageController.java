//package com.msc.monitorServer.controller;
//
//import com.msc.monitorServer.model.dto.ServerMessageDto;
//import com.msc.monitorServer.model.enums.TabNameEnum;
//import com.msc.monitorServer.service.ServerMessageService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import lombok.RequiredArgsConstructor;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/serverMessage")
//@RequiredArgsConstructor
//@CrossOrigin
//@Validated
//public class ServerMessageController {
//
//    private final ServerMessageService serverMessageService;
//
//    @PostMapping
//    public ServerMessageDto create(@RequestBody ServerMessageDto serverMessageDto){
//        return serverMessageService.create(serverMessageDto);
//    }
//
//    @PutMapping
//    public ServerMessageDto update(@RequestBody ServerMessageDto serverMessageDto){
//        return serverMessageService.update(serverMessageDto);
//    }
//
//    @GetMapping
//    public List<ServerMessageDto> get(@RequestParam TabNameEnum tabName){
//        return serverMessageService.get(tabName);
//    }
//}
