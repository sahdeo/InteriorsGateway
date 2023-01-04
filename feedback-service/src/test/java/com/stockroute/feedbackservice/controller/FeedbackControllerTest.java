package com.stockroute.feedbackservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockroute.feedbackservice.dto.Feedbackdetails;
import com.stockroute.feedbackservice.repository.FeedbackDao;
import com.stockroute.feedbackservice.service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class FeedbackControllerTest {

    @Autowired
    private MockMvc mockmvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private FeedbackService feedbackService;
    @MockBean
    private FeedbackDao dao;

    @Test
    void test_AddFeedback_addedSucessfully() throws Exception {
        Feedbackdetails feedbackdetails = new Feedbackdetails();
        feedbackdetails.setServiceName("designers");
        feedbackdetails.setReviewComments("good");
        feedbackdetails.setRating(5);
        feedbackdetails.setDesignerEmail("anjichinna@gmail.com");
        feedbackdetails.setCustomerEmail("chinnaanji@gmail.com");
        Mockito.when(dao.save(Mockito.any(Feedbackdetails.class))).thenReturn(feedbackdetails);
        this.mockmvc.perform(post("/feedback/api/v1/addFeedback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(feedbackdetails)))
                .andExpect(status().isOk());
    }


        @Test
    void test_updateFeedback_updatedSucessfully()throws Exception {
        Feedbackdetails feedbackdetails = new Feedbackdetails();
        feedbackdetails.setServiceName("designers");
        feedbackdetails.setReviewComments("bad");
        feedbackdetails.setRating(2);
        feedbackdetails.setDesignerEmail("anjichinna@gmail.com");
        feedbackdetails.setCustomerEmail("chinnaanji@gmail.com");
        Mockito.when(dao.save(Mockito.any(Feedbackdetails.class))).thenReturn(feedbackdetails);
        this.mockmvc.perform(put("/feedback/api/v1/updatefeedback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(feedbackdetails)))
                .andExpect(status().isOk());


    }
    @Test
    void test_getFeedbackDetails_returnedSucessfully() throws Exception{
        Feedbackdetails feedbackdetails= new Feedbackdetails();
        feedbackdetails.setId("feedbackId");
        feedbackdetails.setServiceName("designers");
        feedbackdetails.setReviewComments("bad");
        feedbackdetails.setRating(2);
        feedbackdetails.setDesignerEmail("anjichinna@gmail.com");
        feedbackdetails.setCustomerEmail("chinnaanji@gmail.com");
        Mockito.when(dao.findById(Mockito.any(String.class))).thenReturn(Optional.of(feedbackdetails));
        this.mockmvc.perform(get("/feedback/api/v1/feedbackId")
                        .contentType(MediaType.APPLICATION_JSON))
                //  .content(mapper.writeValueAsString("63abdb30f7d55302b69297c3")))
                .andExpect(status().isOk());


    }
    @Test
    void test_getDetailsByDesignerEmailId_returnedSucessfully() throws Exception{
        Feedbackdetails feedbackdetails= new Feedbackdetails();
        feedbackdetails.setId("63abdb30f7d55302b69297c3");
        feedbackdetails.setServiceName("designers");
        feedbackdetails.setReviewComments("bad");
        feedbackdetails.setRating(2);
        feedbackdetails.setDesignerEmail("anjichinna@gmail.com");
        feedbackdetails.setCustomerEmail("chinnaanji@gmail.com");
        List<Feedbackdetails> list= new ArrayList<>();
        list.add(feedbackdetails);
        Mockito.when(dao.findByDesignerEmail(Mockito.any(String.class))).thenReturn((Optional.of(list)));
        this.mockmvc.perform(get("/feedback/api/v1/feedback/designerEmail?designerEmail=anjichinna@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString("63abdb30f7d55302b69297c3")))
                .andExpect(status().isOk());


    }


}
