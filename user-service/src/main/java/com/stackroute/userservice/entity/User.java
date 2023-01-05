package com.stackroute.userservice.entity;



import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;


@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
@Document("user_registration")
public class User {


    @Id
    private String userName;

    @Field(name="email_id")
    private String emailId;


    @Field(name="first_name")
    private String userFirstName;

    @Field(name="last_name")
    private String userLastName;

    @Field(name="password")
    private String password;

    @Field(name="confirm_password")
    private String confirmPassword;

    @Field(name="mobile_no")
    private String mobileNo;

    @Field(name="role")
    private Role role;

   /* public User(String emailId, String userName, String userFirstName, String userLastName, String password, String confirmPassword, String mobileNo, Role role) {
        this.emailId = emailId;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.mobileNo = mobileNo;
        this.role = role;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getEmailId(), user.getEmailId()) && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getUserFirstName(), user.getUserFirstName()) && Objects.equals(getUserLastName(), user.getUserLastName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getConfirmPassword(), user.getConfirmPassword()) && Objects.equals(getMobileNo(), user.getMobileNo()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailId(), getUserName(), getUserFirstName(), getUserLastName(), getPassword(), getConfirmPassword(), getMobileNo(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "emailId='" + emailId + '\'' +
                ", userName='" + userName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", role=" + role +
                '}';
    }
}
