package com.stockroute.designerservice.design.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DesignDetails {
    private  String designModel;
    private int designCode;
    private int designPrice;
}
