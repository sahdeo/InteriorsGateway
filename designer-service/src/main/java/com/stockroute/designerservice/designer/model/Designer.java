package com.stockroute.designerservice.designer.model;

import com.stockroute.designerservice.design.model.DesignDetails;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Designers")
public class Designer {
    @Id
    private String designerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private LocalDateTime startDate;
    private String endDate;
    private boolean status;
}
