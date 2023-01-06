package com.stackroute.orderservice.dto;

import com.stackroute.orderservice.model.ShippingDetails;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class OrderDetails {

    String orderId;
    LocalDateTime orderDated;
    Double discount;
    Double totalAmount;

    String customerName;
    String customerEmailId;
    ShippingDetails shippingDetails;
    String designId;
    String designName;
    Double designPrice;
}
