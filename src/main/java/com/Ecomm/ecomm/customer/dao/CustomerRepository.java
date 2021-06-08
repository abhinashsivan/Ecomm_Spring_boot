package com.Ecomm.ecomm.customer.dao;

import com.Ecomm.ecomm.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
