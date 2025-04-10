package com.example.leapkart.mapper;


import com.example.leapkart.dto.request.SellerRequest;
import com.example.leapkart.dto.response.SellerResponse;
import com.example.leapkart.entity.Seller;

public class SellerConverter {
    public static Seller sellerRequestToSeller(SellerRequest sellerRequest)
    {
        return Seller.builder()
                .name(sellerRequest.getName())
                .email(sellerRequest.getEmail())
                .gender(sellerRequest.getGender())
                .gstNo(sellerRequest.getGstNo())
                .build();
    }

    public static SellerResponse sellerToSellerResponse(Seller seller)
    {
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .build();
    }
}
