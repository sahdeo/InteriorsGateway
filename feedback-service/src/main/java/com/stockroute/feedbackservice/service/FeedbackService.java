package com.stockroute.feedbackservice.service;

import com.stockroute.feedbackservice.dto.Feedbackdetails;
import com.stockroute.feedbackservice.exception.InvalidArgumentException;

import java.util.List;

public interface FeedbackService {

    public void addFeedback(Feedbackdetails feedbackdetails);

   public  void updateFeedback(Feedbackdetails feedbackdetails) throws InvalidArgumentException;

   public Feedbackdetails getFeedback(String feedbackId) throws InvalidArgumentException;


    List<Feedbackdetails> getFeedbackByEmailId(String designerEmail) throws InvalidArgumentException;
}
