package com.example.springdatajpa.Controller;

import com.example.springdatajpa.Entity.Customer;
import com.example.springdatajpa.Service.CustomerService;
import com.example.springdatajpa.Service.PartialCustomer;
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
    @CrossOrigin
    @GetMapping("/{id}")
    ResponseEntity<Object> getAllCustomers(@PathVariable String id)  {
       Customer customer=customerService.findAllDetails(Integer.parseInt(id));
        HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.add("1StHeader","Second header");
         httpHeaders.add("2ndHeader","Second header");
        return new ResponseEntity<>(customer,httpHeaders,HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/names")
    List<Customer> getAllDetails(@RequestParam String nmes){

        return customerService.findNameDetails(nmes);
    }

    //Update Marzi wale fields with Load and save approach
    //@Pathcmapping can be used to update a set of fileds INSTEAD of receiving entire body in Request
    @PutMapping("/update/{id}")
    ResponseEntity<Customer> updateCustomer(@RequestBody Hashtable<String,String> hashbody,@PathVariable String id){

        System.out.println(hashbody);

          return ResponseEntity.ok(customerService.Update(hashbody,Integer.parseInt(id)));


    }
    @PatchMapping("/patchupdate/{id}")
    ResponseEntity<?> patchCustomer(@RequestBody PartialCustomer partialCustomer,@RequestParam String id){
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("PatchMethod","Done");
        return ResponseEntity.ok(httpHeaders);
    }

    @DeleteMapping("/remove/{lastname}")
    ResponseEntity<?> deleteCustomer(@PathVariable String lastname){
        System.out.println(" "+lastname);
        return ResponseEntity.ok(customerService.deleteByIdAndLastName(70,lastname));
    }

}
