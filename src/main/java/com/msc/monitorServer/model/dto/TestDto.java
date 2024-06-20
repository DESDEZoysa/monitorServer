package com.msc.monitorServer.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDto {

    private String email;
    private String phoneNumber;
    private String plainText;
    private Date dateTime;
}
