package com.example.leapkart.controller;


import com.example.leapkart.dto.request.CustomerRequest;
import com.example.leapkart.dto.response.CustomerResponse;
import com.example.leapkart.entity.Customer;
import com.example.leapkart.entity.Enum.Gender;
import com.example.leapkart.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor  //generates constructor for all the final fields of the class
public class CustomerController {

    //field injection
//    @Autowired
//    CustomerService customerService;

    //constructor injection
    private final CustomerService customerService;

//    public CustomerController(CustomerService customerService)
//    {
//        this.customerService=customerService;
//    } no need to write this cus RequiredArgsConstructor

    Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @Tag(name="Customer" , description = "API to add Customer")
    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        logger.info("Received add customer request: "+ customerRequest);
        return customerService.addCustomer(customerRequest);

    }

    @GetMapping("/all")
    public List<CustomerResponse> getAllCustomer()
    {

        return customerService.getAllCustomer();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") int id)
    {
        try{
            logger.info("Recieved get customer request for id: "+id);
            Customer response=customerService.getCustomerById(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            logger.info("Not able to find customer for id: "+id);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
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

//    @GetMapping("/gender/{gender}/age/{age}")
//    public List<CustomerResponse> getCustomerByGenderAndAge(@PathVariable("gender") Gender gender,@PathVariable("age") int age)
//    {
//        List<CustomerResponse> responseList=customerService.getCustomerByGenderAndAgeGreaterThan(gender,age);
//        return responseList;
//    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getCustomerByGenderAndAgeByQuery(@PathVariable("gender") Gender gender,@PathVariable("age") int age)
    {
        return customerService.getCustomerByGenderAndAgeGreaterThanByQuery(gender,age);
    }

    @GetMapping("/logs")
    public void getLogs()
    {
        logger.trace("This is a TRACE log");
        logger.debug("This is a DEBUG log");
        logger.info("This is a INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is a ERROR log");
    }
}
