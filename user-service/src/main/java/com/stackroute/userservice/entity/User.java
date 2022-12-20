package com.stackroute.userservice.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document("user_registration")
public class User {
    @Id
    private String id;


    @Field(name="email_id")
    private String emailId;

    @Field(name="user_name")
    private String userName;

    @Field(name="password")
    private String password;

    @Field(name="confirm_password")
    private String confirmPassword;

    @Field(name="mobile_no")
    private String MobileNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public User(String emailId, String userName, String password, String confirmPassword, String mobileNo) {
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        MobileNo = mobileNo;
    }


    public User(String id, String emailId, String userName, String password, String confirmPassword, String mobileNo) {
        this.id = id;
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        MobileNo = mobileNo;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getEmailId(), user.getEmailId()) && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getConfirmPassword(), user.getConfirmPassword()) && Objects.equals(getMobileNo(), user.getMobileNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmailId(), getUserName(), getPassword(), getConfirmPassword(), getMobileNo());
    }
}
