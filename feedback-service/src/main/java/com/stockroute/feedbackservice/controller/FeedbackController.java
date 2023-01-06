package com.stockroute.feedbackservice.controller;
import com.stockroute.feedbackservice.dto.Feedbackdetails;
import com.stockroute.feedbackservice.exception.InvalidArgumentException;
import com.stockroute.feedbackservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feedbackService")
@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(value = "/addFeedback", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addFeedback(@RequestBody Feedbackdetails feedbackdetails) {
        feedbackService.addFeedback(feedbackdetails);
        return "Sucessfully added";
    }

    @PutMapping(value = "/updatefeedback", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateFeedaback(@RequestBody Feedbackdetails feedbackdetails) throws InvalidArgumentException{
        feedbackService.updateFeedback(feedbackdetails);
        return "updated Sucessfully";

    }
    @GetMapping(value = "/feedbackId/{feedbackId}")
    public Feedbackdetails getFeedbackDetails(@PathVariable String feedbackId) throws InvalidArgumentException {

        Feedbackdetails feedbackdetails = feedbackService.getFeedback(feedbackId);
        return feedbackdetails;
    }

    @GetMapping(value = "/feedback/designerEmail")
    public List<Feedbackdetails> getDetailsBydesignerEmailId(@RequestParam String designerEmail) throws InvalidArgumentException {

        List<Feedbackdetails> feedbackdetails = feedbackService.getFeedbackByEmailId(designerEmail);
        return feedbackdetails;

    }
}
