package com.msc.monitorServer.model.dto;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerMessageDto {

    private Integer id;
    private String prompt;
    private String initialChoicesText;
    private String updatedChoicesText;
}
