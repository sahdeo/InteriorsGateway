package com.stockroute.feedbackservice.controller;
import com.stockroute.feedbackservice.dto.Feedbackdetails;
import com.stockroute.feedbackservice.exception.InvalidArgumentException;
import com.stockroute.feedbackservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feedbackService")
@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(value = "/addFeedback", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addFeedback(@RequestBody Feedbackdetails feedbackdetails) {
        feedbackService.addFeedback(feedbackdetails);
        return new ResponseEntity<>("Sucessfully added", HttpStatus.CREATED);

    }

    @PutMapping(value = "/updatefeedback", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateFeedaback(@RequestBody Feedbackdetails feedbackdetails) throws InvalidArgumentException{
        feedbackService.updateFeedback(feedbackdetails);
        return new ResponseEntity<>("updated Sucessfully", HttpStatus.ACCEPTED);

    }
    @GetMapping(value = "/feedbackId/{feedbackId}")
    public ResponseEntity<Feedbackdetails> getFeedbackDetails(@PathVariable String feedbackId) throws InvalidArgumentException {
        Feedbackdetails feedbackdetails = feedbackService.getFeedback(feedbackId);
        return new ResponseEntity<Feedbackdetails>(feedbackdetails, HttpStatus.OK);
    }

    @GetMapping(value = "/feedback/designerEmail")
    public ResponseEntity<List<Feedbackdetails>> getDetailsBydesignerEmailId(@RequestParam String designerEmail) throws InvalidArgumentException {

        List<Feedbackdetails> feedbackdetails = feedbackService.getFeedbackByEmailId(designerEmail);
        return new ResponseEntity<>(feedbackdetails, HttpStatus.OK);
    }
}
