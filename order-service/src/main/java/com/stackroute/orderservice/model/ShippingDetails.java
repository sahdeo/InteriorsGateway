package com.stackroute.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class ShippingDetails {

    private String city;
    private String state;
    private String pinCode;
    private String country;
}
