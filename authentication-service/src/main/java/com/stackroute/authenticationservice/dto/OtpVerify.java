package com.stackroute.authenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpVerify {
    private String emailId;
    private Integer otp;
    private String newPassword;
}
