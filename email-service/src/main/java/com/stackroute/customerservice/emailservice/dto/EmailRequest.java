<<<<<<< HEAD:email-service/src/main/java/com/stackroute/customerservice/emailservice/dto/EmailRequest.java
package com.stackroute.customerservice.emailservice.dto;
=======
package com.stackroute.emailservice.model;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:email-service/src/main/java/com/stackroute/emailservice/model/EmailRequest.java

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private String toEmail;
    private String emailSubject;
    private String emailBody;

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}
