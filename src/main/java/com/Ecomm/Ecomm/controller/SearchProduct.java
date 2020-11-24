package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SearchProduct {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/product/search")
    public String searchProduct(@RequestParam Long id) {

        Optional<Product> product = productService.findProductById(id);

        if (product.isPresent())
            return "Results\n NAME: " + product.get().getProductName() + "Reviewed Users: " + product.get().getReviewedUsers();
        else
            return "product not found";
    }
}
