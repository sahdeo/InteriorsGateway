package rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String emailId;
    private Integer otp;
}
