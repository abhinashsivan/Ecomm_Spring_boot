package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Customer;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.ProductService;
import com.Ecomm.Ecomm.services.yamlFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class AddProduct {


    @Autowired
    ProductRepository productRepositoy;
    @Autowired
    ProductService productService;
    @Autowired
    yamlFileServices yamlFileServices;

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/product/add")
    public String addProduct(@RequestParam(name = "pname") String productName, @RequestParam(name = "ids") List<Long> reviewerCusIds) throws FileNotFoundException {
        boolean exist = true;

        for (Long id : reviewerCusIds) {

            String url = yamlFileServices.getUrl() + "?id=" + id;
            Customer customer = restTemplate.getForObject(url, Customer.class);
            if (customer == null)
                exist = false;

        }

        if (!exist)
            return "Customer not found";

        productService.saveToDB(new Product(productName, reviewerCusIds.toString()));


        return "product saved " + productName;
    }
}
