package rabbit.domain;

import lombok.Data;

@Data
public class EmailDto {
    private String emailId;
    private String name;
    private int otp;
}
