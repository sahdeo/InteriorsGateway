package com.stockroute.designerservice.designer.model;

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
@Document(collection = "Designers")
public class DesignerEntity {
    @Id
    private String designerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String startDate;
    private String endDate;
    private boolean Status;

}
