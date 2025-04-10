package com.example.leapkart.dto.request;

import com.example.leapkart.entity.Address;
import com.example.leapkart.entity.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    String name;

    String email;

    int age;

    Gender gender;

    AddressRequest addressRequest;

//    @Override
//    public String toString() {
//        return "CustomerRequest{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                '}';
//    }
}

