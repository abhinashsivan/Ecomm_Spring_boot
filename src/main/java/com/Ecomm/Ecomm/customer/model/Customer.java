package com.Ecomm.Ecomm.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Customer {

    @Id
    @GeneratedValue
    private Long cusId;
    private String cusName;

    public Customer() {
    }

    public Customer(String cusName) {
        this.cusName = cusName;
    }

    public Customer(Long cusId, String cusName) {
        this.cusId = cusId;
        this.cusName = cusName;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "Customer Info {" +
                "customer Id=" + cusId +
                ", customer Name='" + cusName + '\'' +
                '}';
    }
}
