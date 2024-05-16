package com.msc.monitorServer.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompletionResponseDto {

    private String id;
    private List<CompletionChoice> choices;
}

