package com.stackroute.userservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddUser {

    @Size(min = 2,max=20,message = "name should between 2 and 20")
    @NotBlank(message = "name can't be blank or empty")
    private String userName;


    @Email
    @NotBlank(message = "Email id can't be blank or empty")
    private String emailId;


    @NotBlank(message = "Password can't be blank or empty")
    private String password;


    @NotBlank(message = "ConfirmPassword can't be blank or empty")
    private String confirmPassword;

    @NotBlank(message = "Mobile no. can't be blank or empty")
    private String MobileNo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }
}

