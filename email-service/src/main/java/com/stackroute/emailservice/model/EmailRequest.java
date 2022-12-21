package com.stackroute.emailservice.model;

public class EmailRequest {
    private String toEmail;
    private String emailSubject;
    private String emailBody;

    public EmailRequest() {

    }

    public EmailRequest(String toEmail, String emailSubject, String emailBody) {
        this.toEmail = toEmail;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
    }

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
