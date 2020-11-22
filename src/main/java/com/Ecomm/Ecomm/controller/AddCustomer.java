package com.Ecomm.Ecomm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCustomer {

    @GetMapping("/customer/add")
    public String addCustomer(@RequestParam String name){

        //input validation
        if(name.isBlank())
            return "Check your Inputs";



        return "New Customer Added";
    }
}
