package com.Ecomm.Ecomm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchCustomer {
    public SearchCustomer() {

    }

    @GetMapping("/customer/search")
    public String searchCustomer (@RequestParam int id) {


        return "";

    }

}
