package com.Ecomm.Ecomm.controller;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Customer;
import com.Ecomm.Ecomm.model.Product;
import com.Ecomm.Ecomm.services.CustomerService;
import com.Ecomm.Ecomm.services.ProductService;
import com.Ecomm.Ecomm.services.yamlFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.util.List;

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


    @GetMapping("/product/add")
    public ResponseEntity<String> addProduct(@RequestParam(name = "pname") String productName, @RequestParam(name = "ids") List<Long> reviewerCusIds) throws FileNotFoundException {
        boolean exist = true;

        for (Long id : reviewerCusIds) {
            System.out.println(id);
            String url = yamlFileServices.getUrl() + "?id=" + id;
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*Going to if for- "+id+"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(responseEntity.getBody());
            if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
                System.out.println("In F1");
                exist = false;
                break;

            }
        }

        if (exist == false) {
            System.out.println("IN f2");
            return new ResponseEntity<String>("User Not Found", HttpStatus.BAD_REQUEST);

        }


        productService.saveToDB(new Product(productName, reviewerCusIds.toString()));
        return new ResponseEntity<String>("Product Added", HttpStatus.ACCEPTED);
    }
}
