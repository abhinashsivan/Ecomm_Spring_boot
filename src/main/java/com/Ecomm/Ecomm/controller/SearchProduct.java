package com.Ecomm.Ecomm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchProduct {

    @GetMapping("/product/search")
     public String searchProduct (@RequestParam Long id){




        return "";
    }
}
