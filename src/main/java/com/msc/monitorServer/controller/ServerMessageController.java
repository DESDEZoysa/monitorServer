package com.msc.monitorServer.controller;

import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.model.enums.TabNameEnum;
import com.msc.monitorServer.service.ServerMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serverMessage")
@RequiredArgsConstructor
@CrossOrigin
public class ServerMessageController {

    private final ServerMessageService serverMessageService;

    @PostMapping
    public ServerMessageDto create(@RequestBody ServerMessageDto serverMessageDto){
        return serverMessageService.create(serverMessageDto);
    }

    @PutMapping
    public ServerMessageDto update(@RequestBody ServerMessageDto serverMessageDto){
        return serverMessageService.update(serverMessageDto);
    }

    @GetMapping
    public List<ServerMessageDto> get(TabNameEnum tabName){
        return serverMessageService.get(tabName);
    }
}
