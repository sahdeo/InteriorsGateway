package com.stackroute.userservice.dto;

import com.stackroute.userservice.entity.Role;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private String emailId;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;

    private String mobileNo;

    private Role role;


}
