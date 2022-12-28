package com.stackroute.customerservice.authenticationservice.service;

import com.stackroute.customerservice.authenticationservice.dto.JwtRequest;
import com.stackroute.customerservice.authenticationservice.dto.JwtResponse;
import com.stackroute.customerservice.authenticationservice.entity.User;
import com.stackroute.customerservice.authenticationservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtServiceImp implements UserDetailsService, IJwtService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private com.stackroute.customerservice.authenticationservice.dao.IUserDao IUserDao;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        Optional<User> optional = IUserDao.findById(userName);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("User '"+userName+"'not found");
        }
        return new JwtResponse(optional.get(), newGeneratedToken);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = IUserDao.findById(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("User '"+username+"'not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(optional.get().getUserPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_" + optional.get().getRole()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
/**
 *  .authorities(String.valueOf(optional.get().getRole()))
 *   .accountExpired(false)
 *   .accountLocked(false)
 *    .credentialsExpired(false)
 *    .disabled(false)
 *      .build()
 */