package com.stackroute.paymentservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @Autowired
    private PaytmDetails paytmDetails;

    @GetMapping("/")
    public String home() {
        return "home";
    }
}


