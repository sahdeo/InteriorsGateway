package com.stackroute.customerservice.service;


import com.stackroute.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public void createUser(Customer customer);

    public Customer getByEmailId(String customerEmailId);

    public Customer updateUser(Customer user, String emailId);

    public String deleteUser(String customerEmailId);

    public List<Customer> getAllUser();
}
