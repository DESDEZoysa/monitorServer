package com.msc.monitorServer.controller;

import com.msc.monitorServer.config.exeption.ErrorResponse;
import com.msc.monitorServer.model.dto.ServerMessageDto;
import com.msc.monitorServer.model.dto.TestDto;
import com.msc.monitorServer.model.enums.TabNameEnum;
import com.msc.monitorServer.model.exeption.InvalidEmailFormatException;
import com.msc.monitorServer.service.ServerMessageService;
import com.msc.monitorServer.util.RequestVariableValidator;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@CrossOrigin
public class TestController {

    private final ServerMessageService serverMessageService;
    private final RequestVariableValidator requestVariableValidator;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data is valid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TestDto.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid data format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/getDetail01")
    public List<TestDto> getContactDetails(@Parameter(schema = @Schema(type = "string", format = "email"))@RequestParam String email, @RequestParam Integer num){
        requestVariableValidator.validateEmailFormat(email);
        return Arrays.asList(TestDto.builder().email(email).build());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data is valid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TestDto.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid data format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/getDetail01")
    public List<TestDto> getContactDetailsP(@Parameter(schema = @Schema(type = "string", format = "email"))@RequestParam String email,
                                            @RequestParam Integer num, @RequestBody HashMap map){
        requestVariableValidator.validateEmailFormat(email);
        return Arrays.asList(TestDto.builder().email(email).build());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "HashMap is valid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TestDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/getDetail02/{plainTextPath}/{emailPath}")
    public TestDto getDetail(@PathVariable String plainTextPath,
                             @Parameter(schema = @Schema(type = "string", format = "email"))@PathVariable String emailPath){
        requestVariableValidator.validateString(plainTextPath);
        requestVariableValidator.validateEmailFormat(emailPath);
        return TestDto.builder().plainText(plainTextPath).build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "HashMap is valid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TestDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PutMapping("/getDetail02/{plainTextPath}/{emailPath}")
    public TestDto getDetailP(@PathVariable String plainTextPath,
                             @Parameter(schema = @Schema(type = "string", format = "email"))@PathVariable String emailPath,
                              @RequestBody HashMap map){
        requestVariableValidator.validateString(plainTextPath);
        requestVariableValidator.validateEmailFormat(emailPath);
        return TestDto.builder().plainText(plainTextPath).build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data is valid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/getDetail03/{isAdd}")
    public List<String> getDetailDateTime(@RequestParam Integer num, @PathVariable Boolean isAdd){
        return Arrays.asList("addefe","dwdwqdwdw","wdqwd","wdqwd");
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data is valid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/getDetail03/{isAdd}")
    public List<String> getDetailDateTimeP(@RequestParam Integer num, @PathVariable Boolean isAdd, @RequestBody HashMap map){
        return Arrays.asList("addefe","dwdwqdwdw","wdqwd","wdqwd");
    }

//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Data is valid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))),
//            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
//    })
//    @GetMapping("/getDetail03")
//    public Boolean getDetailBoolean(@RequestParam Boolean bool){
//        return bool;
//    }

//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Data is valid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Integer.class)))),
//            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
//    })
//    @GetMapping("/getDetail04")
//    public List<Integer> getDetailNum1(@RequestParam Long num){
//        return Arrays.asList(23,45,67,100);
//    }

//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Data is valid"),
//            @ApiResponse(responseCode = "400", description = "Invalid email format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
//    })
//    @GetMapping("/getDetail05")
//    public void getDetailPost(@Parameter(schema = @Schema(type = "string", format = "email"))@RequestParam String email){
//        requestVariableValidator.validateEmailFormat(email);
//        System.out.println("wertyytre");
//    }
//
//    @GetMapping("/getDetail06")
//    public TestDto getEmailDetails(@Parameter(schema = @Schema(type = "string", format = "email"))@RequestParam String email){
//        requestVariableValidator.validateEmailFormat(email);
//        return TestDto.builder().email(email).build();
//    }

}
