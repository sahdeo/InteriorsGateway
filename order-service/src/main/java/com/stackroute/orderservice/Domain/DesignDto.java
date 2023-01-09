package com.stackroute.orderservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignDto {
    private String designId;
    private String designName;
    private String customerEmailId;
    private int designPrice;

}
