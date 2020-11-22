package com.Ecomm.Ecomm.Model;

import java.util.List;

public class Product {

    int productId;
    String productName;
    List<Integer> reviewedUsers;

    public Product() {
    }

    public Product(int productId, String productName, List<Integer> reviewedUsers) {
        this.productId = productId;
        this.productName = productName;
        this.reviewedUsers = reviewedUsers;
    }

    public int getProductId() { return productId; }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Integer> getReviewedUsers() {
        return reviewedUsers;
    }

    public void setReviewedUsers(List<Integer> reviewedUsers) {
        this.reviewedUsers = reviewedUsers;
    }
}
