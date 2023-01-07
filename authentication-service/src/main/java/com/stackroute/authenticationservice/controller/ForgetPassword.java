//package com.stackroute.authenticationservice.controller;
//
//import com.stackroute.authenticationservice.dto.OtpVerify;
//import com.stackroute.authenticationservice.entity.User;
//import com.stackroute.authenticationservice.exception.OtpNotValidException;
//import com.stackroute.authenticationservice.exception.UserNotFoundException;
//import com.stackroute.authenticationservice.service.IUserService;
//import com.stackroute.authenticationservice.service.UserServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import rabbitmq.domain.EmailDto;
//import rabbitmq.domain.UserDto;
//
//@RestController
//@RequestMapping("/passwordService")
//public class ForgetPassword {
//    @Autowired
//    private UserServiceImp userService;
//
//    @PostMapping("/forgetPassword")
//    public ResponseEntity<EmailDto> forgotPassword(@RequestParam String emailId) throws UserNotFoundException {
//        EmailDto emailDto = userService.forgotPassword(emailId.trim().toString());
//        return new ResponseEntity<>(emailDto, HttpStatus.OK);
//    }
//
//    @PutMapping("/updatePassword")
//    public ResponseEntity<String> resetPassword(@RequestBody OtpVerify otpVerify) throws UserNotFoundException, OtpNotValidException {
//        String response = userService.updatePassword(otpVerify);
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }
//}
