package com.example.leapkart.repository;

import com.example.leapkart.entity.Customer;
import com.example.leapkart.entity.Enum.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    //custom method
//    List<Customer> findByGenderAndAgeGreaterThan(Gender gender, int age);

////SQL Query
//    @Query(value="SELECT * FROM customer_details WHERE gender = :g AND age > :a")
//    List<Customer> findByGenderAndAgeGreaterThanByQuery(String g,int a);


    @Query(value="select c from Customer c where c.gender = :g AND c.age > :a ")
    List<Customer> findByGenderAndAgeGreaterThanByQuery(Gender g,int a);






}
