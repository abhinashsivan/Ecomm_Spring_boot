package com.Ecomm.Ecomm.model;

import java.util.List;

public class Product {

    Long productId;
    String productName;
    List<Long> reviewedUsers;

    public Product() {
    }

    public Product(Long productId, String productName, List<Long> reviewedUsers) {
        this.productId = productId;
        this.productName = productName;
        this.reviewedUsers = reviewedUsers;
    }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Long> getReviewedUsers() {
        return reviewedUsers;
    }

    public void setReviewedUsers(List<Long> reviewedUsers) {
        this.reviewedUsers = reviewedUsers;
    }
}
