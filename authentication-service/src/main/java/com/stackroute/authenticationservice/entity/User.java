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
    @Column(name = "username")
    private String userName;
    @Column(name = "firstName")
    private String userFirstName;
    @Column(name = "lastName")
    private String userLastName;

    @Length( min = 8,message = "password must contain at least 8 characters")
    @Column(name = "password")
    private String userPassword;
    @Column(name = "user_role")
    private Roles role;

}
