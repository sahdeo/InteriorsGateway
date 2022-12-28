package com.stackroute.authenticationservice.entity;

import com.stackroute.authenticationservice.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_AUTH")
public class User {
    @Id
    @NotBlank(message = "userName shouldn't be blank")
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "firstName")
    private String userFirstName;
    @Column(name = "lastName")
    private String userLastName;
    @Length( min = 8,message = "password must contain at least 8 characters")
    @Column(name = "password")
    private String userPassword;
    @Length( min = 8,message = "password must contain at least 8 characters")
    @Column(name = "confirmed_password")
    private String confirmPassword;
    @Column(name = "contact_no")
    private String mobileNo;
    @Column(name = "user_role")
    private Roles role;

}

//    private String emailId;
//
//    @Field(name="user_name")
//    private String userName;
//
//    @Field(name="first_name")
//    private String userFirstName;
//
//    @Field(name="last_name")
//    private String userLastName;
//
//    @Field(name="password")
//    private String password;
//
//    @Field(name="confirm_password")
//    private String confirmPassword;
//
//    @Field(name="mobile_no")
//    private String mobileNo;
//
//    @Field(name="role")
//    private Role role;
