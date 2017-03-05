package com.ecommerce.domain;

/**
 * Created by jeswin on 05/03/17.
 */
public class ProductRequest {

    private String sku;
    private String name;
    private String description;


    private long category;
    private long country;
    private long store;
    private float amount;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }

    public long getStore() {
        return store;
    }

    public void setStore(long store) {
        this.store = store;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }



}
