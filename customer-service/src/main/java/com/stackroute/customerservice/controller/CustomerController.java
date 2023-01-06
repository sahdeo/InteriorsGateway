package com.stackroute.customerservice.controller;


import com.stackroute.customerservice.dto.AddCustomer;
import com.stackroute.customerservice.dto.CustomerDetails;
import com.stackroute.customerservice.dto.UpdateCustomer;
import com.stackroute.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerService")
public class CustomerController {

    private CustomerService customerServiceImpl;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerServiceImpl=customerService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<CustomerDetails> createUser(@RequestBody AddCustomer customer) throws Exception{
        CustomerDetails details=customerServiceImpl.createUser(customer);
    return new ResponseEntity<>(details, HttpStatus.CREATED);
    }
    @GetMapping("/getUserByEmail/")
    public ResponseEntity<CustomerDetails> getUserByEmail(@RequestParam String customerEmailId) throws Exception{
        CustomerDetails details=customerServiceImpl.getByEmailId(customerEmailId);
        return new ResponseEntity<>(details,HttpStatus.OK);
    }

    @PutMapping("/updateUser/")
    public ResponseEntity<CustomerDetails> updateUser(@RequestBody UpdateCustomer customer, @RequestParam String customerEmailId) throws Exception{
        CustomerDetails details=customerServiceImpl.updateUser(customer,customerEmailId);
        return new ResponseEntity<>(details,HttpStatus.OK);
    }
    @DeleteMapping("/deleteUserByEmail/")
    public ResponseEntity<String> deleteUser(@RequestParam String customerEmailId) throws Exception{
        customerServiceImpl.deleteUser(customerEmailId);
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }
    @GetMapping("/getAllUser/")
    public ResponseEntity<List<CustomerDetails>> fetchAll(){
        List<CustomerDetails> customerDetailsList=customerServiceImpl.fetchAll();
        return new ResponseEntity<>(customerDetailsList, HttpStatus.OK);
    }

}
