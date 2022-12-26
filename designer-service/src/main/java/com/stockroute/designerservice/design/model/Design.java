package com.stockroute.designerservice.design.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Designs")
public class Design {
    @Id
    private String designId;
    private String designName;
    private String ratings;
    private String color;
    private double size;
    private byte[] image;
    private DesignDetails designDetails;
}
