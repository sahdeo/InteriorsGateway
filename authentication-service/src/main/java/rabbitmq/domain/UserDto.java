package rabbitmq.domain;

import com.stackroute.authenticationservice.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String emailId;

    private String userFirstName;

    private String userLastName;

    private String userPassword;

    private String confirmPassword;

    private String mobileNo;

    private int otp;

    private Roles role;
}
