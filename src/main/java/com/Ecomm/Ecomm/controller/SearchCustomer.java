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
public class SearchCustomer {

    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repository;

    public SearchCustomer() { }

    @GetMapping("/customer/search")
    public ResponseEntity<String> searchCustomer (@RequestParam Long id) {

        ResponseEntity<Customer> responseEntity = service.checkCustomerById(id);

     if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
         return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
     else
         return new ResponseEntity<>(repository.findById(id).get().toString(), HttpStatus.FOUND);

    }

}
