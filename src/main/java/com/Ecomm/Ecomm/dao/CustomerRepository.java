package com.Ecomm.Ecomm.dao;

import com.Ecomm.Ecomm.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
