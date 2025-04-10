package com.example.leapkart.mapper;

import com.example.leapkart.dto.request.AddressRequest;
import com.example.leapkart.entity.Address;

public class AddressConverter {

    public static Address addressRequestToAddress(AddressRequest addressRequest)
    {
        return Address.builder()
                .flatNo(addressRequest.getFlatNo())
                .city(addressRequest.getCity())
                .build();

    }
}
