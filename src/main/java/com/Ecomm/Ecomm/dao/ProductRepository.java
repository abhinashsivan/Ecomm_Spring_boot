package com.Ecomm.Ecomm.dao;

import com.Ecomm.Ecomm.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
