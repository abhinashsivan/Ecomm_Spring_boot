package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.CustomerService;
import com.Ecomm.Ecomm.services.ProductService;
import com.Ecomm.Ecomm.services.yamlFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;

@RestController
public class AddProduct {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductRepository productRepositoy;
    @Autowired
    ProductService productService;
    @Autowired
    yamlFileServices yamlFileServices;

    RestTemplate restTemplate = new RestTemplate();


    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(@RequestParam(name = "pname") String productName, @RequestParam(name = "ids") Long[] reviewerCusIds) throws FileNotFoundException {
        boolean exist = true;

        for (Long id : reviewerCusIds) {
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


        productService.saveToDB(new Product(productName, reviewerCusIds));
        return new ResponseEntity<>("PRODUCT ADDED", HttpStatus.ACCEPTED);
    }
}
