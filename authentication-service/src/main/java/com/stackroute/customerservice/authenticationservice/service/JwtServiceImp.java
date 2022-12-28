package com.stackroute.customerservice.authenticationservice.service;

<<<<<<< HEAD:authentication-service/src/main/java/com/stackroute/customerservice/authenticationservice/service/JwtServiceImp.java
import com.stackroute.customerservice.authenticationservice.dto.JwtRequest;
import com.stackroute.customerservice.authenticationservice.dto.JwtResponse;
import com.stackroute.customerservice.authenticationservice.entity.User;
import com.stackroute.customerservice.authenticationservice.util.JwtUtil;
=======
import com.stackroute.authenticationservice.dao.UserDao;
import com.stackroute.authenticationservice.dto.JwtRequest;
import com.stackroute.authenticationservice.dto.JwtResponse;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.util.JwtUtil;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:authentication-service/src/main/java/com/stackroute/authenticationservice/service/JwtService.java
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService, IJwtService{

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
<<<<<<< HEAD:authentication-service/src/main/java/com/stackroute/customerservice/authenticationservice/service/JwtServiceImp.java
    private com.stackroute.customerservice.authenticationservice.dao.IUserDao IUserDao;
=======
    private UserDao userDao;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:authentication-service/src/main/java/com/stackroute/authenticationservice/service/JwtService.java

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        Optional<User> optional = userDao.findById(userName);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }
        User user = optional.get();
        return new JwtResponse(user, newGeneratedToken);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userDao.findById(username);

        if (optional.isPresent()) {
            User user = optional.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
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