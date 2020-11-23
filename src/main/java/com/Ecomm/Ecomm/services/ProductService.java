package com.Ecomm.Ecomm.services;

import com.Ecomm.Ecomm.dao.ProductRepository;
import com.Ecomm.Ecomm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepositoy;

    public ProductService(ProductRepository productRepositoy) {
        this.productRepositoy = productRepositoy;
    }

    public boolean saveToDB(Product product){
        boolean sucessfull = true;

        try{
            productRepositoy.save(product);
        }
        catch (Exception e){
            sucessfull = false;
        }

        return sucessfull;

    }

    public Optional<Product> findProductById(long id){
        boolean sucess = true;

        Optional<Product> product = productRepositoy.findById(id);

        return product;
    }
}
