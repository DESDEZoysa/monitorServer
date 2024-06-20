package com.msc.monitorServer.model.dto;

import com.msc.monitorServer.model.enums.UserRoleEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserDto {

    private Integer id;
    private String userName;
    private String password;
    private UserRoleEnum userRole;
}
