package com.ecommerce.domain;

import javax.persistence.*;

/**
 * Created by jeswin on 11/02/17.
 */


@Entity
public class Product {


    @Id @GeneratedValue
    private long id;
    private String sku;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;



    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;


    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;


    Product() {}
    public Product(String sku, String name, String description, Category category, Store store, Country country) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.category = category;
        this.store = store;
        this.country = country;

    }

    public long getId() { return id; }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Store getStore() {
        return store;
    }

    public String toString() {
        return sku + "  " + name + " desc: " + description;
    }

}
