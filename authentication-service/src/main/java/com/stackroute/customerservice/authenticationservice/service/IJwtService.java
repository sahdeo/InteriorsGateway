package com.stackroute.customerservice.authenticationservice.service;

import com.stackroute.customerservice.authenticationservice.dto.JwtRequest;
import com.stackroute.customerservice.authenticationservice.dto.JwtResponse;

public interface IJwtService {
    JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception;
}
