package com.Ecomm.Ecomm.product.dao;

import com.Ecomm.Ecomm.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
