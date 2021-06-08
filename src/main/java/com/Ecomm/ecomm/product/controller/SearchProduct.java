package com.Ecomm.ecomm.product.controller;

import com.Ecomm.ecomm.customer.dao.CustomerRepository;
import com.Ecomm.ecomm.product.dao.ProductRepository;
import com.Ecomm.ecomm.product.model.Product;
import com.Ecomm.ecomm.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/product")
    public ResponseEntity<String> searchProduct(@RequestParam Long id) {

        Optional<Product> product = productService.findProductById(id);


        if (product.isPresent()) {

            List<String> reviewedCusNames = new ArrayList<>();

            for (Long eachId : product.get().getReviewedUsers()) {
                if (customerRepository.findById(eachId).isPresent()) {
                    reviewedCusNames.add(customerRepository.findById(eachId).get().getCusName());
                }

                else{
                    return new ResponseEntity<>("No corresponding user found in  user table", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return new ResponseEntity<>("product name: " + product.get().getProductName().toUpperCase() +
                    " \n reviewed users: " + reviewedCusNames.toString().toUpperCase(), HttpStatus.FOUND);
        } else
            return new ResponseEntity<>("NO SUCH PRODUCT FOUND", HttpStatus.NOT_FOUND);
    }
}
