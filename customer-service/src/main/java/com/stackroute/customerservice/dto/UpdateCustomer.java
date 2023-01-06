package com.stackroute.customerservice.dto;

import com.stackroute.customerservice.model.Gender;
import lombok.Data;

@Data
public class UpdateCustomer {
    //private String customerEmailId;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String city;
    private String state;
    private String pinCode;
    private String country;
    private Gender gender;
}
