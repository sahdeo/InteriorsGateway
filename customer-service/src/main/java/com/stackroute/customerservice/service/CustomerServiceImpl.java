package com.stackroute.customerservice.service;


import com.stackroute.customerservice.dto.AddCustomer;
import com.stackroute.customerservice.dto.CustomerDetails;
import com.stackroute.customerservice.dto.UpdateCustomer;
import com.stackroute.customerservice.exception.CustomerNotFoundException;
import com.stackroute.customerservice.exception.MobileNoNotValidException;
import com.stackroute.customerservice.repository.CustomerRepository;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.util.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    private  CustomerRepository customerRepository;
    private CustomerDetail detail;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,CustomerDetail detail){
    this.customerRepository=customerRepository;
    this.detail=detail;
    }
    @Override
    public CustomerDetails createUser(AddCustomer requestData) throws MobileNoNotValidException{

        contactNumberValidator(requestData.getMobileNo());

        Customer customer=new Customer();
        customer.setCustomerEmailId(requestData.getCustomerEmailId());
        customer.setFirstName(requestData.getFirstName());
        customer.setLastName(requestData.getLastName());
        customer.setMobileNo(requestData.getMobileNo());
        customer.setGender(requestData.getGender());
        customer.setCity(requestData.getCity());
        customer.setState(requestData.getState());
        customer.setPinCode(requestData.getPinCode());
        customer.setCountry(requestData.getCountry());
        customer=customerRepository.save(customer);
        return detail.toCustomerDetails(customer);
    }

    @Override
    public CustomerDetails getByEmailId(String customerEmailId) throws CustomerNotFoundException{
        Optional<Customer> optionalCustomer=customerRepository.findByCustomerEmailId(customerEmailId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found by emailId= " + customerEmailId);
        }
        return detail.toCustomerDetails(optionalCustomer.get());
    }

    @Override
    public CustomerDetails updateUser(UpdateCustomer updateData, String customerEmailId) throws CustomerNotFoundException{
        Optional<Customer> found = customerRepository.findByCustomerEmailId(customerEmailId);
        Customer customerFound= found.get();
        Customer customer=new Customer();

        customer.setCustomerEmailId(customerEmailId);
        if(updateData.getFirstName().equals("string"))
            customer.setFirstName(customerFound.getFirstName());
        else customer.setFirstName(updateData.getFirstName());
        if(updateData.getLastName().equals("string"))
            customer.setLastName(customerFound.getLastName());
        else customer.setLastName(updateData.getLastName());
        if(updateData.getMobileNo().equals("string"))
            customer.setMobileNo(customerFound.getMobileNo());
        else customer.setMobileNo(updateData.getMobileNo());
        if(updateData.getGender().equals("string"))
            customer.setGender(customerFound.getGender());
        else customer.setGender(updateData.getGender());
        if(updateData.getCity().equals("string"))
            customer.setCity(customerFound.getCity());
        else customer.setCity(updateData.getCity());
        if(updateData.getState().equals("string"))
            customer.setState(customerFound.getState());
        else customer.setState(updateData.getState());
        if(updateData.getPinCode().equals("string"))
            customer.setPinCode(customerFound.getPinCode());
        else customer.setPinCode(updateData.getPinCode());
        if(updateData.getCountry().equals("string"))
            customer.setCountry(customerFound.getCountry());
        else customer.setCountry(updateData.getCountry());
        if(found.isPresent()){
            customerRepository.save(customer);
        }else {
            throw new CustomerNotFoundException("Customer not found by emailId= "+ customerEmailId);
        }
        return detail.toCustomerDetails(customer);
    }

    @Override
    public String deleteUser(String customerEmailId) throws CustomerNotFoundException{
        getByEmailId(customerEmailId);
        customerRepository.deleteById(customerEmailId);
        return "Customer Deleted Successfully";
    }

    @Override
    public List<CustomerDetails> fetchAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDetails> desired = detail.toUserDetailsList(customers);
        return desired;

    }

    public void contactNumberValidator(String mobileNo) throws MobileNoNotValidException {
        if (mobileNo.length() != 10) {
            throw new MobileNoNotValidException("Mobile number is less that 10 digits Please enter valid mobile number");
        } else {
            return;
        }

    }

}
