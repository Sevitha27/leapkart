package com.example.leapkart.service;

import com.example.leapkart.dto.request.CustomerRequest;
import com.example.leapkart.dto.response.CustomerResponse;
import com.example.leapkart.entity.Address;
import com.example.leapkart.entity.Customer;
import com.example.leapkart.entity.Enum.Gender;
import com.example.leapkart.mapper.AddressConverter;
import com.example.leapkart.mapper.CustomerConverter;
import com.example.leapkart.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //dto to entity
        Customer customer= CustomerConverter.customerRequestToCustomer(customerRequest);

        Address address= AddressConverter.addressRequestToAddress(customerRequest.getAddressRequest());
        customer.setAddress(address);  //customer entity
        address.setCustomer(customer); //address entity

        Customer savedCustomer=customerRepository.save(customer); //saving both customer and address cus of cascading relationship


        //entity to dto
        return CustomerConverter.customerToCustomerResponse(savedCustomer);
    }



    public List<CustomerResponse> getAllCustomer() {

        List<Customer> customers =customerRepository.findAll();
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers)
        {
            CustomerResponse response=CustomerConverter.customerToCustomerResponse(customer);
            customerResponses.add(response);
        }

        return customerResponses;
    }

    public Customer getCustomerById(int id) {
        Optional<Customer> customerOptional= customerRepository.findById(id);
        if(customerOptional.isEmpty())
        {
            throw new RuntimeException("Inavlid Customer ID");
        }

        Customer savedCustomer=customerOptional.get();

//        return CustomerConverter.customerToCustomerResponse(savedCustomer);
        return savedCustomer;
    }


    public boolean deleteCustomerById(int id) {

        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public void deleteAllCustomerRec() {
        customerRepository.deleteAll();
    }

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThanByQuery(Gender gender, int age) {
        List<Customer> customers=customerRepository.findByGenderAndAgeGreaterThanByQuery(gender,age);
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers)
        {
            CustomerResponse response=CustomerConverter.customerToCustomerResponse(customer);
            customerResponses.add(response);
        }

        return customerResponses;
    }
}
