package com.stackroute.customerservice.dto;

import com.stackroute.customerservice.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddCustomer {

    @Email
    @NotBlank(message = "Email id can't be blank or empty")
    private String customerEmailId;

    @NotBlank(message = "First Name can't be blank or empty")
    private String firstName;

    @NotBlank(message = "Last Name can't be blank or empty")
    private String lastName;

    @NotBlank(message = "Mobile no. can't be blank or empty")
    private String mobileNo;

    @NotBlank(message = "City can't be blank or empty")
    private String city;
    @NotBlank(message = "State can't be blank or empty")
    private String state;
    @NotBlank(message = "pinCode can't be blank or empty")
    @Max(6)
    private String pinCode;
    @NotBlank(message = "pinCode can't be blank or empty")
    private String country;

    private Gender gender;

}



