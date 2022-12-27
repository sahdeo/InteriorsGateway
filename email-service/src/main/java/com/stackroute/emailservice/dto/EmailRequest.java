package com.stackroute.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailRequest {
    private String name;
    private String toEmail;
    private String emailSubject;
    /*private String emailBody;*/
    private String emailFrom;


}
