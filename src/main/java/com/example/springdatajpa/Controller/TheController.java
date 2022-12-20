package com.example.springdatajpa.Controller;

import com.example.springdatajpa.Entity.Customer;
import com.example.springdatajpa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springdatajpa.Exception.CustomerNotFoundException;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

@RestController
public class TheController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    ResponseEntity<Object> getAllCustomers(@PathVariable String id)  {
       Customer customer=customerService.findAllDetails(Integer.parseInt(id));
        HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.add("1StHeader","Second header");
         httpHeaders.add("2ndHeader","Second header");
        return new ResponseEntity<>(customer,httpHeaders,HttpStatus.OK);
    }
    @PostMapping("/names")
    List<Customer> getAllDetails(@RequestParam String nmes){

        return customerService.findNameDetails(nmes);
    }

    //Update Marzi wale fields with Load and save approach
    @PutMapping("/update/{id}")
    ResponseEntity<Customer> updateCustomer(@RequestBody Hashtable<String,String> hashbody,@PathVariable String id){

        System.out.println(hashbody);

          return ResponseEntity.ok(customerService.Update(hashbody,Integer.parseInt(id)));


    }

}
