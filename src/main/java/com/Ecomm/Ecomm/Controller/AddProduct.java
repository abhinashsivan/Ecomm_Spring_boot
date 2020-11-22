package com.Ecomm.Ecomm.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddProduct {

    @GetMapping("/product/add")
    public String addProduct(@RequestParam(required = true) String productName, @RequestParam(required = true) List<Long> cusIds){


        return "";
    }
}
