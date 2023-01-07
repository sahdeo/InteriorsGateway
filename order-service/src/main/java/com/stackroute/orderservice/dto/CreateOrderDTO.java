package com.stackroute.orderservice.dto;

import com.stackroute.orderservice.model.ShippingDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateOrderDTO {

    @NotBlank
    String orderId;
    LocalDateTime orderDated;
    Double discount;
    Double totalAmount;

    String customerName;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotBlank(message = "Email id can't be blank or empty")
    String customerEmailId;
    ShippingDetails shippingDetails;
    @NotBlank(message = "Design id can't be blank or empty")
    String designId;
    String designName;
    Integer designPrice;
}
