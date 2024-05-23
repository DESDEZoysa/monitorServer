package com.msc.monitorServer.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerMessageDto {

    @Schema(description = "primary key of the table", example = "25", type = "integer")
    @Min(0)
    @Max(2147483647)
    private Integer id;
    @Schema(description = "prompt value", example = "aB2", type = "string")
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "prompt should be valid")
    private String prompt;
    @Schema(description = "initialChoicesText value which can be either '1' or '0'", example = "1", type = "string")
    @Pattern(regexp = "^(1|0|2)$", message = "Status can only be '1' or '0'")
    private String initialChoicesText;
    @Schema(description = "updatedChoicesText value which can be either '1' or '0'", example = "1", type = "string")
    @Pattern(regexp = "^(1|0|2)$", message = "Status can only be '1' or '0'")
    private String updatedChoicesText;
}
