package com.stockroute.designerservice.design.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Designs")
@Builder
public class Design {
    @Id
    private String designId;
    private String designName;
    private String ratings;
    private String color;
    private double size;
    @Schema(hidden=true)
   private byte[] image;
    private DesignDetails designDetails;
}
