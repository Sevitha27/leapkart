package com.example.leapkart.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "customer_details")
public class Customer {

    @Id
    int id;

    @Min(3)
    String name;

    @Column(name="email_id" ,unique = true, nullable = false)
    String email;

    int age;
}
