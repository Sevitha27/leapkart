package com.example.leapkart.service;

import com.example.leapkart.dto.request.SellerRequest;
import com.example.leapkart.dto.response.SellerResponse;
import com.example.leapkart.entity.Enum.Gender;
import com.example.leapkart.entity.Seller;
import com.example.leapkart.mapper.SellerConverter;
import com.example.leapkart.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public String addSeller(SellerRequest sellerRequest)
    {
        //Step 1-> dto to entity
        Seller seller= SellerConverter.sellerRequestToSeller(sellerRequest);
        sellerRepository.save(seller);
        return "seller saved successfully!";
    }

    public List<SellerResponse> getSellerById(Gender gender) {
        List<Seller> sellers=sellerRepository.findByGender(gender);

        List<SellerResponse> sellerResponses= new ArrayList<>();
        for(Seller seller:sellers)
        {
            sellerResponses.add(SellerConverter.sellerToSellerResponse(seller));
        }
        return sellerResponses;
    }


}
