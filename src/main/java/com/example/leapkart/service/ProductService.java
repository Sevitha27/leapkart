package com.example.leapkart.service;

import com.example.leapkart.dto.request.ProductRequest;
import com.example.leapkart.dto.response.ProductResponse;
import com.example.leapkart.entity.Product;
import com.example.leapkart.entity.Seller;
import com.example.leapkart.exception.SellerNotFoundException;
import com.example.leapkart.mapper.ProductConverter;
import com.example.leapkart.repository.ProductRepository;
import com.example.leapkart.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final SellerRepository sellerRepository;

    public ProductResponse addProduct(int sellerId, ProductRequest productRequest)
    {
        Optional<Seller> optionalSeller=sellerRepository.findById(sellerId);
        if(optionalSeller.isEmpty()){
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Seller seller=optionalSeller.get();

        Product product= ProductConverter.productRequestToProduct(productRequest);

        seller.getProducts().add(product);
        product.setSeller(seller);

        sellerRepository.save(seller);
        Product savedProduct=productRepository.save(product);

        return ProductConverter.productToProductResponse(savedProduct);
    }
}
