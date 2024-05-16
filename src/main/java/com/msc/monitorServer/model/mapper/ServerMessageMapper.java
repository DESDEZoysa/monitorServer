package com.msc.monitorServer.model.mapper;

import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.model.entity.ServerMessageEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServerMessageMapper {

    public ServerMessageEntity dtoToEntity(ServerMessageDto serverMessageDto){
        return ServerMessageEntity
                .builder()
                .id(serverMessageDto.getId())
                .prompt(serverMessageDto.getPrompt())
                .initialChoicesText(serverMessageDto.getInitialChoicesText())
                .updatedChoicesText(serverMessageDto.getUpdatedChoicesText())
                .build();
    }

    public ServerMessageDto entityToDto(ServerMessageEntity serverMessageEntity){
        return ServerMessageDto
                .builder()
                .id(serverMessageEntity.getId())
                .prompt(serverMessageEntity.getPrompt())
                .initialChoicesText(serverMessageEntity.getInitialChoicesText())
                .updatedChoicesText(serverMessageEntity.getUpdatedChoicesText())
                .build();
    }

    public ServerMessageDto entityToDto(ServerMessageEntity serverMessageEntity, ServerMessageDto serverMessageDto){
        return ServerMessageDto
                .builder()
                .id(serverMessageEntity.getId())
                .prompt(serverMessageDto.getPrompt() == null ? serverMessageEntity.getPrompt() : serverMessageDto.getPrompt())
                .initialChoicesText(serverMessageDto.getInitialChoicesText() == null ? serverMessageEntity.getInitialChoicesText() : serverMessageDto.getInitialChoicesText())
                .updatedChoicesText(serverMessageDto.getUpdatedChoicesText() == null ?  serverMessageEntity.getUpdatedChoicesText() : serverMessageDto.getUpdatedChoicesText())
                .build();
    }
    public List<ServerMessageDto> entityLstToDtoList(List<ServerMessageEntity> serverMessageEntityList){
        return serverMessageEntityList.stream().map(this :: entityToDto).collect(Collectors.toList());
    }
}
