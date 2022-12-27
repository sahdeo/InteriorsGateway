package rabbitmq.domain;

import com.stackroute.authenticationservice.enums.Roles;
import lombok.Data;

@Data
public class UserDto {
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private Roles role;
}
