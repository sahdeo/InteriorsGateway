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
@Document(collection = "Designs")
public class Design {
    private String designId;
    private String designName;
    private String designDeatils;
    private String designPrice;
    private String ratings;
    private String color;
    private double size;
    private DesignDetails designDetails;
}






