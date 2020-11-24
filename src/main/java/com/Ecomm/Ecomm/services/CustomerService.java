package com.Ecomm.Ecomm.services;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public boolean saveCustomertoDB(Customer customer) {
        boolean success = true;
        try {
            repository.save(customer);
        } catch (Exception e) {
            System.out.println("exception - "+e);
            success = false;
        }

        return  success;
    }

    public ResponseEntity<Customer> checkCustomerById(@RequestParam  long id){



        if(repository.existsById(id)){
            Customer customer = new Customer();
            customer.setCusName(repository.findById(id).get().getCusName());
            customer.setCusId(repository.findById(id).get().getCusId());
            return new ResponseEntity<>(customer, HttpStatus.FOUND);

        }
        else
            return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_FOUND);

    }

}
