package com.example.leapkart.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    String name;

    int price;

    SellerResponse seller;

}
