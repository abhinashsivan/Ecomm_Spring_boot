package com.Ecomm.ecomm.product.controller;

import com.Ecomm.ecomm.product.dao.ProductRepository;
import com.Ecomm.ecomm.product.model.Product;
import com.Ecomm.ecomm.customer.services.CustomerService;
import com.Ecomm.ecomm.product.services.ProductService;
import com.Ecomm.ecomm.product.services.yamlFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;

@RestController
public class AddProduct {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    yamlFileServices yamlFileServices;

    RestTemplate restTemplate = new RestTemplate();


    @PostMapping(value= "/product", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> addProduct(@RequestBody Product product) throws FileNotFoundException {
        boolean exist = true;


        for (Long id : product.getReviewedUsers()) {
            String url = yamlFileServices.getUrl() + "?id=" + id;
            try {
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            } catch (RestClientResponseException exception) {
                if (exception.getRawStatusCode() == 404) {
                    exist = false;
                    break;
                }
            }
        }

        if (!exist) {
            return new ResponseEntity<>("NO SUCH CUSTOMER FOUND", HttpStatus.BAD_REQUEST);
        }
        productService.saveToDB(product);
        return new ResponseEntity<>("PRODUCT ADDED", HttpStatus.ACCEPTED);
    }
}
