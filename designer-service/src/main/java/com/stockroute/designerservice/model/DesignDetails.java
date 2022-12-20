package com.stockroute.designerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DesignDetails")
public class DesignDetails {
    private  String designModel;
    private int designCode;
    private String designtModel;
    private int designPrice;
}
