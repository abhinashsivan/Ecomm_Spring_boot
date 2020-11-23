package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.CustomerService;
import com.Ecomm.Ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddProduct {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductRepository productRepositoy;
    @Autowired
    ProductService productService;

    @GetMapping("/product/add")
    public String addProduct(@RequestParam(name = "pname") String productName, @RequestParam(name = "ids") List<Long> reviewerCusIds){
         boolean exist = true;
         for(Long id: reviewerCusIds)
                exist = customerService.findCustomerById(id).isPresent();
         if(!exist)
                return "Customer not found";

        productService.saveToDB(new Product(productName, reviewerCusIds.toString()));




        return "product saved "+productName;
    }
}
