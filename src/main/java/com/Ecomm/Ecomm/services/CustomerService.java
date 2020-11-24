package com.Ecomm.Ecomm.services;

import com.Ecomm.Ecomm.dao.CustomerRepository;
import com.Ecomm.Ecomm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    public Customer checkCustomerById(@RequestParam  long id){

        Customer customer;

        if(repository.existsById(id)){
            customer = new Customer(repository.findById(id).get().getCusId(), repository.findById(id).get().getCusName());

        }
        else
            customer = new Customer("CUSTOMER NOT FOUND");

        return customer;
    }

}
