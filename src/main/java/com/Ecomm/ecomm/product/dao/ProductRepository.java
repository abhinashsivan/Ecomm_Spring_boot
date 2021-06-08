package com.Ecomm.ecomm.product.dao;

import com.Ecomm.ecomm.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
