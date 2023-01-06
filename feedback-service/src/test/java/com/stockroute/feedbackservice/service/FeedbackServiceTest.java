//package com.stockroute.feedbackservice.service;
//import com.stockroute.feedbackservice.dto.Feedbackdetails;
//import com.stockroute.feedbackservice.exception.InvalidArgumentException;
//import com.stockroute.feedbackservice.repository.FeedbackDao;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Optional;
//@ExtendWith(MockitoExtension.class)
//class FeedbackServiceTest {
//    @Autowired
//    FeedbackService feedbackService;
//    @Mock
//    FeedbackDao dao;
//    @BeforeEach
//    public void before() {
//        feedbackService = new FeedbackServiceImpl(dao);
//    }
//    @Test
//    void test_AddFeedback_ShouldSaveSucessfully() {
//        Feedbackdetails feedbackdetails = new Feedbackdetails();
//        feedbackdetails.setServiceName("design");
//        feedbackdetails.setReviewComments("good");
//        feedbackdetails.setRating(5);
//        feedbackdetails.setDesignerEmail("designer@gmail.com");
//        feedbackdetails.setCustomerEmail("anji@gmail.com");
//        feedbackService.addFeedback(feedbackdetails);
//    }
//    @Test
//    void test_getFeedbackDetails_recivedDetailsSucessfully() throws InvalidArgumentException {
//        Feedbackdetails feedbackdetails = new Feedbackdetails();
//        feedbackdetails.setServiceName("design");
//        feedbackdetails.setReviewComments("good");
//        feedbackdetails.setRating(5);
//        feedbackdetails.setDesignerEmail("dessign@gmail.com");
//        feedbackdetails.setId("ab253v");
//        feedbackdetails.setBookingId("101");
//        Mockito.when(dao.findById(Mockito.any(String.class))).thenReturn(Optional.of(feedbackdetails));
//        Feedbackdetails details = feedbackService.getFeedback("ab253v");
//        Assertions.assertTrue(details.getBookingId().equals(feedbackdetails.getBookingId()));
//        Assertions.assertTrue(details.getServiceName().equals(feedbackdetails.getServiceName()));
//    }
//}
//
