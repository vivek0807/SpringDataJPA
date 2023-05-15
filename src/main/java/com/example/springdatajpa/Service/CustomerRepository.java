package com.example.springdatajpa.Service;

import com.example.springdatajpa.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerId(int id);
    @Query("SELECT C FROM Customer C WHERE C.customerId<15")
    List<Customer> findAllByNameStyle(String nameStyle);

    Long removeByCustomerId(int id);
    @Modifying
    @Transactional
    @Query("DELETE FROM Customer WHERE customerId=:CUSTOMERID  AND lastName=:LASTNAME")
    List<Integer> removeCustomer(@Param("CUSTOMERID") int CUSTOMERID,@Param("LASTNAME") String LASTNAME);

}
