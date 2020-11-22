package com.Ecomm.Ecomm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddProduct {

    @GetMapping("/product/add")
    public String addProduct(@RequestParam String productName, @RequestParam List<Long> cusIds){


        return "";
    }
}
