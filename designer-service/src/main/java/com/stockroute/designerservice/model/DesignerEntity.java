package com.stockroute.designerservice.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String EmailId;
    private String startDate;
    private String endDate;
    private boolean Status;

}
