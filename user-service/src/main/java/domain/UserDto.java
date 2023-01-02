package domain;

import com.stackroute.userservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String emailId;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String mobileNo;
    private Role role;
}
