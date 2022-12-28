package com.stackroute.customerservice.model;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
@Document("User")
public class Customer {
    @Id
    private String customerEmailId;
            String firstName;
            String lastName;
            String city;
            String state;
            String pinCode;
            String phoneNo;
            Gender gender;
            Address address;
}
