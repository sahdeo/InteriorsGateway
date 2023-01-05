package com.stackroute.orderservice.dto;

import com.stockroute.designerservice.design.model.Design;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AddCart {

    @Email
    @NotBlank(message = "Email id can't be blank or empty")
    private String customerEmailId;
    private LocalDateTime cartAddedDated;
    private List<Design> designList;
    @Min(0)
    private Double discount;
    @Min(0)
    private Double totalAmount;
}
