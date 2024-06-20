package com.msc.monitorServer.controller;
import com.msc.monitorServer.config.exeption.ErrorResponse;
import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.model.dto.TestDto;
import com.msc.monitorServer.model.enums.TabNameEnum;
import com.msc.monitorServer.service.ServerMessageService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/serverMessage")
@RequiredArgsConstructor
@CrossOrigin
@Validated
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved server messages", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ServerMessageDto.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid tabName", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping
    public List<ServerMessageDto> get(){
        return serverMessageService.get(TabNameEnum.Alert);
    }


}
