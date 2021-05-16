package com.Ecomm.Ecomm.customer.controller;

import com.Ecomm.Ecomm.customer.dao.CustomerRepository;
import com.Ecomm.Ecomm.customer.model.Customer;
import com.Ecomm.Ecomm.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCustomer {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerService service;

    @PostMapping("/customer/{name}")
    public ResponseEntity<String> addCustomer(@PathVariable String name) {


        if (name.isBlank())
            return new ResponseEntity<>("CHECK INPUT", HttpStatus.BAD_REQUEST);

        boolean success = service.saveCustomertoDB(new Customer(name));


        if (success)
            return new ResponseEntity<>(new Customer(name).toString(), HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Failed ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
