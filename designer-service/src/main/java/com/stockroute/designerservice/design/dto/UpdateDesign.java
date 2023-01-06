package com.stockroute.designerservice.design.dto;

import com.stockroute.designerservice.design.model.DesignDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UpdateDesign {
    private String designName;
    private String ratings;
    private String color;
    private double size;

    private String designerEmailId;
    private DesignDetails designDetails;

}
