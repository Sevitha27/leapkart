package com.example.leapkart.dto.request;

import com.example.leapkart.entity.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
    String name;

    int price;

    ProductCategory category;

    int availableQuantity;

    //int sellerId; will take it as request param
}
