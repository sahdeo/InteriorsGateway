package rabbit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
