package com.example.leapkart.service;


import com.example.leapkart.entity.Address;
import com.example.leapkart.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address getAddress(int id)
    {
        return addressRepository.findById(id).get();
    }
}
