package com.stockroute.feedbackservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Feedback_details")
public class Feedbackdetails {
    @Id
    private String id;
    private String bookingId;
    private String customerEmail;
    private String designerEmail;
    private Integer rating;
    private String reviewComments;
    private String serviceName;
}
