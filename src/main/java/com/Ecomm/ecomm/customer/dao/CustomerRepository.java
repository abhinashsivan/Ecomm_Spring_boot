package com.Ecomm.Ecomm.customer.dao;

import com.Ecomm.Ecomm.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
