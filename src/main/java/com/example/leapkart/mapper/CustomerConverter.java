package com.example.leapkart.mapper;

import com.example.leapkart.dto.request.CustomerRequest;
import com.example.leapkart.dto.response.CustomerResponse;
import com.example.leapkart.entity.Customer;

public class CustomerConverter {
    public static CustomerResponse customerToCustomerResponse(Customer customer)
    {
//        CustomerResponse customerResponse=new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setEmail(customer.getEmail());
//        return customerResponse;
        return CustomerResponse.builder() //add builder to CustomerResponse class
                .email(customer.getEmail())
                .name(customer.getName())
                .build();
    }

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest)
    {
//        Customer customer=new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        return customer;

        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .build();
    }

}
