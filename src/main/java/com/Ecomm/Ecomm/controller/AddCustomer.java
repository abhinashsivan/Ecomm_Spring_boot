package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.model.Customer;
import com.Ecomm.Ecomm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addCustomer(@RequestParam String name){


        //input validation
        if(name.isBlank())
            return "Check your Inputs";
        boolean sucess = service.saveCustomertoDB(new Customer(name));


        if(sucess)
            return "New Customer Added";
        else
            return "some error";
    }
}
