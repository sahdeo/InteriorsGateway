package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dto.JwtRequest;
import com.stackroute.authenticationservice.dto.JwtResponse;

public interface IJwtService {
    JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception;

}
