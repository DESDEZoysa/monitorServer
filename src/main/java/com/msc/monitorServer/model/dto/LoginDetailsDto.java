package com.msc.monitorServer.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDetailsDto {

    private String userName;
    private String password;
}
