package com.stackroute.userservice.entity;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;


@NoArgsConstructor
@Data
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
    private String mobileNo;

    @Field(name="role")
    private Role role;

    public User(String emailId, String userName, String password, String confirmPassword, String mobileNo, Role role) {
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.mobileNo = mobileNo;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getEmailId(), user.getEmailId()) && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getConfirmPassword(), user.getConfirmPassword()) && Objects.equals(getMobileNo(), user.getMobileNo()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmailId(), getUserName(), getPassword(), getConfirmPassword(), getMobileNo(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", emailId='" + emailId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", role=" + role +
                '}';
    }
}
