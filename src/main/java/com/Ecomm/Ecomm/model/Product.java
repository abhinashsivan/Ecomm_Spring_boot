package com.Ecomm.Ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private String reviewedUsers;

    public Product() {
    }

    public Product(String productName, String reviewedUsers) {
        this.productName = productName;
        this.reviewedUsers = reviewedUsers;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReviewedUsers() {
        return reviewedUsers;
    }

    public void setReviewedUsers(String reviewedUsers) {
        this.reviewedUsers = reviewedUsers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", reviewedUsers='" + reviewedUsers + '\'' +
                '}';
    }
}
