package com.example.springdatajpa.Service;

import com.example.springdatajpa.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerId(int id);
    @Query("SELECT C FROM Customer C WHERE Customerid<15")
    List<Customer> findAllByNameStyle(String nameStyle);

}
