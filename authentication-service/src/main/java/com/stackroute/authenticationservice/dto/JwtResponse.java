package com.stackroute.authenticationservice.dto;

import com.stackroute.authenticationservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private User user;
    private String jwtToken;
}
