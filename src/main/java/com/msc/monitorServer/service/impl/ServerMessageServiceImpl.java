package com.msc.monitorServer.service.impl;

import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.model.entity.ServerMessageEntity;
import com.msc.monitorServer.model.enums.TabNameEnum;
import com.msc.monitorServer.model.mapper.ServerMessageMapper;
import com.msc.monitorServer.repository.ServerMessageRepository;
import com.msc.monitorServer.service.ServerMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerMessageServiceImpl implements ServerMessageService {

    private final ServerMessageRepository serverMessageRepository;
    private final ServerMessageMapper serverMessageMapper;

    @Override
    public ServerMessageDto create(ServerMessageDto serverMessageDto) {
        return serverMessageMapper.entityToDto(serverMessageRepository.save(getServerMessageEntity(serverMessageDto)));
    }

    @Override
    public ServerMessageDto update(ServerMessageDto serverMessageDto) {
        ServerMessageEntity serverMessageEntity = serverMessageRepository.findById(serverMessageDto.getId()).get();
        serverMessageDto = serverMessageMapper.entityToDto(serverMessageEntity,serverMessageDto);
        return serverMessageMapper.entityToDto(serverMessageRepository.save(serverMessageMapper.dtoToEntity(serverMessageDto)));
    }

    @Override
    public List<ServerMessageDto> get(TabNameEnum tabName) {
        List<ServerMessageEntity> serverMessageEntityList = new ArrayList<>();
        if(TabNameEnum.Alert.equals(tabName)){
            serverMessageEntityList = serverMessageRepository.findAllByInitialChoicesTextAndUpdatedChoicesTextIsNull("1");
        }else if(TabNameEnum.Event.equals(tabName)){
            serverMessageEntityList = serverMessageRepository.findAllByInitialChoicesTextOrUpdatedChoicesText("0","0");
        }else if(TabNameEnum.FalsePositive.equals(tabName)){
            int x = 10/0;
            serverMessageEntityList = serverMessageRepository.findAllByInitialChoicesTextAndUpdatedChoicesText("1","1");
        }
        return serverMessageMapper.entityLstToDtoList(serverMessageEntityList);
    }

    private ServerMessageEntity getServerMessageEntity(ServerMessageDto serverMessageDto){
        return serverMessageMapper.dtoToEntity(
                ServerMessageDto
                .builder()
                .id(0)
                .prompt(serverMessageDto.getPrompt())
                .initialChoicesText(serverMessageDto.getInitialChoicesText())
                .updatedChoicesText(null)
                .build()
        );
    }

}
