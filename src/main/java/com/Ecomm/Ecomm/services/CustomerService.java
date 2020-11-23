package com.Ecomm.Ecomm.services;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public boolean saveCustomertoDB(Customer customer) {
        boolean success = true;
        try {
            repository.save(customer);
        } catch (Exception e) {
            System.out.println("exception - "+e);
            success = false;
        }

        return  success;

    }

}
