package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.model.Customer;
import com.Ecomm.Ecomm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SearchCustomer {

    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repository;

    public SearchCustomer() { }

    @GetMapping("/customer/search")
    public String searchCustomer (@RequestParam Long id) {

        Optional<Customer> customer = service.findCustomerById(id);

        if(customer.isPresent())
            return "name is "+customer.get().getCusName();
        else
            return "User not found";

    }

}
