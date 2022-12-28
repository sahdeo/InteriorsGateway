package com.stackroute.customerservice.userservice.dto;

import com.stackroute.customerservice.userservice.entity.Role;
import lombok.Data;


@Data
public class UserDetails {

    private String id;

    private String emailId;

    private String userName;

    private String password;

    private String confirmPassword;

    private String mobileNo;

    private Role role;

}
