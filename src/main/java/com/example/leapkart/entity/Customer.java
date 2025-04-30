package com.example.leapkart.entity;


import com.example.leapkart.entity.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "customer_details")
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Min(3)
    String name;

    @Column(name="email_id" ,unique = true, nullable = false)
    String email;

    int age;

    @CreationTimestamp
    Date createdAt;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy= "customer", cascade=CascadeType.ALL)
    @JsonIgnore
    Address address;

    @OneToMany(mappedBy = "customer", cascade= CascadeType.ALL)
    List<OrderEntity> orders=new ArrayList<>();
}
