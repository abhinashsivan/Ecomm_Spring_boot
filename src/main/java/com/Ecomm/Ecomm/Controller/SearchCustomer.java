package com.Ecomm.Ecomm.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchCustomer {
    public SearchCustomer() {

    }

    @GetMapping("/customer/search")
    public String searchCus(@RequestParam int id) {
        

        return "";

    }

}
