package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.model.Customer;
import com.Ecomm.Ecomm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCustomer {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerService service;

    @GetMapping("/customer/add")
    public ResponseEntity<String> addCustomer(@RequestParam String name) {


        if (name.isBlank())
            return new ResponseEntity<>("CHECK INPUT", HttpStatus.BAD_REQUEST);

        boolean sucess = service.saveCustomertoDB(new Customer(name));


        if (sucess)
            return new ResponseEntity<>("NEW CUSTOMER ADDED", HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
