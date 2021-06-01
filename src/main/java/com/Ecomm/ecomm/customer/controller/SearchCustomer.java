package com.Ecomm.Ecomm.customer.controller;

import com.Ecomm.Ecomm.customer.dao.CustomerRepository;
import com.Ecomm.Ecomm.customer.model.Customer;
import com.Ecomm.Ecomm.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchCustomer {

    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customer/{id}")
    public ResponseEntity<String> searchCustomer(@PathVariable("id") Long id) {

        ResponseEntity<Customer> responseEntity = service.checkCustomerById(id);

        if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return new ResponseEntity<>("CUSTOMER NOT FOUND", HttpStatus.NOT_FOUND);
        else {
            if (repository.findById(id).isPresent()) {
                return new ResponseEntity<>(repository.findById(id).get().toString(), HttpStatus.FOUND);
            } else
                return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
