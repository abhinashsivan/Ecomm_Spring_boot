package com.Ecomm.Ecomm.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private Long[] reviewedUsers;

    public Product() {
    }

    public Product(String productName, Long[] reviewedUsers) {
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

    public Long[] getReviewedUsers() {
        return reviewedUsers;
    }

    public void setReviewedUsers(Long[] reviewedUsers) {
        this.reviewedUsers = reviewedUsers;
    }


}
