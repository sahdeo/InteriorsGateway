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
    private String firstName;
    private String lastName;
    private String mobileNo;
    private Gender gender;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}
