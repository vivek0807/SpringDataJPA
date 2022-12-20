package com.example.springdatajpa.Service;

import com.example.springdatajpa.Entity.Customer;
import com.example.springdatajpa.Exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;

@Component
@ComponentScan
@Service
public class CustomerService  {
    @Autowired
    CustomerRepository customerRepository;
    @Cacheable(value = "custById",key = "#id")
   public Customer findAllDetails(int id)  {
        List<Customer> customer= customerRepository.findAllByCustomerId(id);
           if (customer.size()==0) {
               System.out.println("throwing Exception");
               throw new CustomerNotFoundException("User not found with id "+id);
           }
           else {

               return customer.get(0);
           }

    }

    public List<Customer> findNameDetails(String nameStyle){
       return  customerRepository.findAllByNameStyle(nameStyle);
    }

    
   public Customer Update(Hashtable<String,String> hashbody,int id){
      Customer customer=customerRepository.findAllByCustomerId(id).get(0);
       for (String s:hashbody.keySet()  ) {
           switch (s) {
               case "namestyle":
                    customer.setNameStyle(hashbody.get("namestyle"));
                    break;
               case "title":
                   customer.setTitle(hashbody.get("title"));
                   break;
               case "firstname":
                   customer.setFirstName(hashbody.get("firstname"));
                   break;
               case "middlename":
                   customer.setMiddleName(hashbody.get("middlename"));
                   break;
               case "suffix":
                   customer.setSuffix("suffix");
                   break;
               case "companyname":
                   customer.setCompanyName(hashbody.get("companyname"));
                   break;
               case "salesperson":
                   customer.setSalesPerson(hashbody.get("salesperson"));
                   break;
               case "phone":
                   customer.setPhone(hashbody.get("phone"));
                   break;

           }
       }

      return customerRepository.save(customer);
    }


}
