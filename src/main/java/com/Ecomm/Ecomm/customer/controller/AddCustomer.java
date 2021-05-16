package com.Ecomm.Ecomm.customer.controller;

import com.Ecomm.Ecomm.customer.dao.CustomerRepository;
import com.Ecomm.Ecomm.customer.model.Customer;
import com.Ecomm.Ecomm.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCustomer {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerService service;

    @PostMapping("/customer/add")
    public ResponseEntity<String> addCustomer(@RequestParam String name) {


        if (name.isBlank())
            return new ResponseEntity<>("CHECK INPUT", HttpStatus.BAD_REQUEST);

        boolean success = service.saveCustomertoDB(new Customer(name));


        if (success)
            return new ResponseEntity<>("NEW CUSTOMER ADDED", HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
