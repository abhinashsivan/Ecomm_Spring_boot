package com.Ecomm.ecomm.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    @NotNull
    @Size(min=2, max=15)
    private String productName;
    private String productDescription;
    private Float productPrice;
    private Long[] reviewedUsers;

    public Product() {
    }

    public Product(String productName, String productDescription, Float productPrice, Long[] reviewedUsers) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Long[] getReviewedUsers() {
        return reviewedUsers;
    }

    public void setReviewedUsers(Long[] reviewedUsers) {
        this.reviewedUsers = reviewedUsers;
    }
}
