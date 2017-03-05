package com.ecommerce.domain;

/**
 * Created by jeswin on 05/03/17.
 */
public class ProductBuilder {

    private String sku;
    private String name;
    private String description;

    private long category;
    private long country;
    private long store;
    private float amount;



    public static ProductBuilder aProductBuilder() {
        return new ProductBuilder();
    }

    public ProductBuilder forSku(String sku) {
        this.sku = sku;
        return this;

    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;

    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder inStore(long store) {
        this.store = store;
        return this;
    }

    public ProductBuilder country(long country) {
        this.country = country;
        return this;
    }

    public ProductBuilder inCategory(long category) {
        this.category = category;
        return this;

    }

    public Product build() {

        return new Product(sku, name, description, new Category(category), new Store(store), new Country(country));
    }



}
