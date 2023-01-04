package com.stackroute.customerservice.service;


import com.stackroute.customerservice.dto.AddCustomer;
import com.stackroute.customerservice.dto.CustomerDetails;
import com.stackroute.customerservice.exception.CustomerNotFoundException;
import com.stackroute.customerservice.exception.MobileNoNotValidException;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.util.CustomerDetail;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CustomerService {

    public CustomerDetails createUser(@Valid AddCustomer customer) throws MobileNoNotValidException;

    public CustomerDetails getByEmailId(String customerEmailId) throws CustomerNotFoundException;

    public CustomerDetails updateUser(@Valid AddCustomer updateData, String emailId) throws CustomerNotFoundException;

    public String deleteUser(String customerEmailId) throws CustomerNotFoundException;

    public List<CustomerDetails> fetchAll();
}
