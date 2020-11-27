package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchProduct {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/product/search/{id}")
    public ResponseEntity<String> searchProduct(@PathVariable Long id) {

        Optional<Product> product = productService.findProductById(id);


        if (product.isPresent()) {

            List<String> reviewedCusNames = new ArrayList<String>();

            for (Long eachid : product.get().getReviewedUsers()) {
                reviewedCusNames.add(customerRepository.findById(eachid).get().getCusName());
            }
            return new ResponseEntity<>("product name: " + product.get().getProductName().toUpperCase() +
                    "  reviewed users: " + reviewedCusNames.toString().toUpperCase(), HttpStatus.FOUND);
        } else
            return new ResponseEntity<>("NO SUCH PRODUCT FOUND", HttpStatus.NOT_FOUND);
    }
}
