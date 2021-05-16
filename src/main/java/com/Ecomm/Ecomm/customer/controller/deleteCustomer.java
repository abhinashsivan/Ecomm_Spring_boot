package com.Ecomm.Ecomm.customer.controller;

import com.Ecomm.Ecomm.customer.dao.CustomerRepository;
import com.Ecomm.Ecomm.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteCustomer {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCus(@PathVariable("id") Long id) {

        if (customerService.checkCustomerById(id).getStatusCode() == HttpStatus.NOT_FOUND) {
            return new ResponseEntity<>("Unable to perform as customer not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        customerRepository.deleteById(id);

        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }
}
