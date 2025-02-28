package com.Ecomm.ecomm.product.services;

import com.Ecomm.ecomm.product.dao.ProductRepository;
import com.Ecomm.ecomm.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepositoy) {
        this.productRepository = productRepositoy;
    }

    public void saveToDB(Product product) {

        productRepository.save(product);

    }
//to Be changed
    public Optional<Product> findProductById(long id) {

        Optional<Product> product = productRepository.findById(id);

        return product;

        //change to standard
    }
}
