package com.msc.monitorServer.util;

import com.msc.monitorServer.config.exeption.InvalidStringrFormatException;
import com.msc.monitorServer.model.exeption.InvalidEmailFormatException;
import com.msc.monitorServer.model.exeption.InvalidPhoneNumberFormatException;
import org.springframework.stereotype.Component;

@Component
public class RequestVariableValidator {

    public void validateEmailFormat(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailFormatException("Invalid_email_format");
        }
    }
    public void validatePhoneNumberFormat(String phoneNumber) {
        String phoneRegex = "^[+]?[0-9]{10,13}$";
        if (!phoneNumber.matches(phoneRegex)) {
            throw new InvalidPhoneNumberFormatException("Invalid_phone_number_format");
        }
    }
    public void validateString(String string) {
        String phoneRegex = "^(?!\\s*$).+";
        if(string == null || "null".equals(string)){
            throw new InvalidStringrFormatException("Invalid_string_format");
        }else{
            if (!string.matches(phoneRegex)) {
                throw new InvalidStringrFormatException("Invalid_string_format");
            }
        }
    }
}
