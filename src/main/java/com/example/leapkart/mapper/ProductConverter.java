package com.example.leapkart.mapper;

import com.example.leapkart.dto.request.ProductRequest;
import com.example.leapkart.dto.response.ProductResponse;
import com.example.leapkart.entity.Product;

public class ProductConverter {

    public static Product productRequestToProduct(ProductRequest productRequest)
    {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .availableQuantity(productRequest.getAvailableQuantity())
                .build();
    }

    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .seller(SellerConverter.sellerToSellerResponse(product.getSeller()))
                .build();
    }
}
