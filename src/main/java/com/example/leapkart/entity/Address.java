package com.example.leapkart.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.security.cert.CertPathBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "address")
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String flatNo;

//    String building;

//    String locality;

    String city;

//    int pincode;

    @OneToOne
    @JoinColumn
    Customer customer;


}
