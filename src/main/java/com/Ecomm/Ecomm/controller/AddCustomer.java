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
    //add
    public String addCustomer(@RequestParam String name) {


        //input validation
        if (name.isBlank())
            return "check inputs";

        boolean sucess = service.saveCustomertoDB(new Customer(name));


        if (sucess)
            return "New Customer: " + name + " added";
        else
            return "Action not successfull";
    }
}
