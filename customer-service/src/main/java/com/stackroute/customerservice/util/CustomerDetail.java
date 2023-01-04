package com.stackroute.customerservice.util;

import com.stackroute.customerservice.dto.AddCustomer;
import com.stackroute.customerservice.dto.CustomerDetails;
import com.stackroute.customerservice.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDetail {

    public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails details=new CustomerDetails();
        details.setCustomerEmailId(customer.getCustomerEmailId());
        details.setFirstName(customer.getFirstName());
        details.setLastName(customer.getLastName());
        details.setMobileNo(customer.getMobileNo());
        details.setGender(customer.getGender());
        details.setCity(customer.getCity());
        details.setState(customer.getState());
        details.setPinCode(customer.getPinCode());
        details.setCountry(customer.getCountry());

        return details;
    }

    public List<CustomerDetails> toUserDetailsList(Collection<Customer> customers){
        List<CustomerDetails>list=  customers.stream()
                .map(this::toCustomerDetails)
                .collect(Collectors.toList());
        return list;
    }
}
