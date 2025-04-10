package com.example.leapkart.controller;


import com.example.leapkart.entity.Address;
import com.example.leapkart.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public Address getAddress(@RequestParam("id") int id)
    {
        return addressService.getAddress(id);
    }

}
