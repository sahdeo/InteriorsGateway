package com.stackroute.authenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    @NotBlank(message = "username must not be blank")
    private String userName;
    //@Length(min = 8, max = 15, message = "password must contain at least 8 characters")
    @Length(min = 8,message = "password must contain at least 8 characters")
    private String userPassword;
}
