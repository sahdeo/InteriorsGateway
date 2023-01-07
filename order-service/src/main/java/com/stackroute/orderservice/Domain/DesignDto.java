package com.stackroute.orderservice.Domain;

import com.stockroute.designerservice.design.model.DesignDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignDto {
    private String designId;
    private String designName;
    private String ratings;
    private String color;
    private double size;
    @Schema(hidden=true)
    private byte[] image;
    private String designerEmailId;
    private DesignDetails designDetails;
}
