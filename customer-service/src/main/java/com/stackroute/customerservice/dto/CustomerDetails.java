package com.stackroute.customerservice.dto;

import com.stackroute.customerservice.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {

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
