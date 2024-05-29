package com.msc.monitorServer.service;

import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.model.enums.TabNameEnum;

import java.util.List;

public interface ServerMessageService {

    ServerMessageDto create(ServerMessageDto serverMessageDto);
    ServerMessageDto update(ServerMessageDto serverMessageDto);
    List<ServerMessageDto> get(TabNameEnum tabName);
    String getByEmai(String email);
}
