package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class SearchProduct {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/product/search")
    public ResponseEntity<String> searchProduct(@RequestParam Long id) {

        Optional<Product> product = productService.findProductById(id);

        if (product.isPresent())
            return new ResponseEntity<>("Product Name: " + product.get().getProductName().toUpperCase() +
                        "  Reviewed Users: " + Arrays.toString(product.get().getReviewedUsers()), HttpStatus.FOUND);
        else
            return new ResponseEntity<>("NO SUCH PRODUCT FOUND", HttpStatus.NOT_FOUND);
    }
}
