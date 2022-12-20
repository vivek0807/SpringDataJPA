package com.example.springdatajpa.Service;

import com.example.springdatajpa.Entity.SalesOrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesOrderHeaderRepository extends JpaRepository<SalesOrderHeader,Integer> {
 public List<SalesOrderHeader> findAllByCustomerId(int custid);
}
