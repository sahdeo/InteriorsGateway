package com.stackroute.controller;


import com.stackroute.model.Customer;
import com.stackroute.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/demo/user")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @PostMapping("/createUser")
    public void createUser(@RequestBody Customer customer){
    customerServiceImpl.createUser(customer);
    }
    @GetMapping("/getUserByEmail/")
    public Customer getUserByEmail(@RequestParam String customerEmailId){
        return customerServiceImpl.getByEmailId(customerEmailId);
    }

    @PutMapping("/updateUser/")
    public Customer updateUser(@RequestBody Customer customer, @RequestParam String customerEmailId){
        return customerServiceImpl.updateUser(customer,customerEmailId);
    }
    @DeleteMapping("/deleteUserByEmail/")
    public String deleteUser(@RequestParam String customerEmailId){
        customerServiceImpl.deleteUser(customerEmailId);
        return "User Deleted Successfully";
    }
    @GetMapping("/getAllUser/")
    public List<Customer> getUserByEmail(){
        return customerServiceImpl.getAllUser();
    }

}
