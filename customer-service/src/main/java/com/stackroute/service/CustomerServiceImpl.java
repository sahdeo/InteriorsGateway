package com.stackroute.service;


import com.stackroute.Dao.CustomerRepository;
import com.stackroute.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {


    private  CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
    this.customerRepository=customerRepository;
}
    @Override
    public void createUser(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getByEmailId(String customerEmailId) {
        return customerRepository.findById(customerEmailId).get();
    }

    @Override
    public Customer updateUser(Customer customer, String customerEmailId) {
        Optional<Customer> optionalUser = customerRepository.findById(customerEmailId);
        if(optionalUser.isPresent()){
            customerRepository.save(customer);
        }
        return customer;
    }

    @Override
    public String deleteUser(String customerEmailId) {
        customerRepository.deleteById(customerEmailId);
        return "Customer Deleted Successfully";
    }

    @Override
    public List<Customer> getAllUser() {
        List<Customer> userList;
        userList = customerRepository.findAll();
        return userList;
    }

}
