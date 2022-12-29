package rabbitmq.domain;

import com.stackroute.authenticationservice.enums.Roles;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;

@Data
public class UserDto {
//    private String userName;
//    private String userFirstName;
//    private String userLastName;
//    private String userPassword;
//    private Roles role;

  //  private PasswordEncoder passwordEncoder;

    private String emailId;

    private String userFirstName;

    private String userLastName;

    private String userPassword;

    private String confirmPassword;

    private String mobileNo;

    private Roles role;





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
}
