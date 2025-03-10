package com.example.leapkart.controller;


import com.example.leapkart.entity.Customer;
import com.example.leapkart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "Customer added successfully!!!";
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomer()
    {
        return customerService.getAllCustomer();
    }

    @GetMapping("/id/{id}")
    public Customer getCustomerById(@PathVariable("id") int id)
    {
         return customerService.getCustomerById(id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomerById(@RequestParam("id") int id)
    {
        boolean deleted = customerService.deleteCustomerById(id);
        if (deleted) {
            return ResponseEntity.ok("Customer with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delAll")
    public String deleteAllCustomerRec()
    {
        customerService.deleteAllCustomerRec();
        return "Deleted all records successfullyyy!!";
    }

}
