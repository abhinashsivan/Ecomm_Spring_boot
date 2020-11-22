package com.Ecomm.Ecomm.Model;

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

    public Customer(Long cus_id, String cus_name) {
        this.cusId = cus_id;
        this.cusName = cus_name;
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

}
