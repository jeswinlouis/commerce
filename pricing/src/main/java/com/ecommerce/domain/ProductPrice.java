package com.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeswin on 27/02/17.
 */

@Entity
public class ProductPrice {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String sku;

    @Column
    private double MRP;

    @Column
    private PricingStrategy pricingStrategy;


    private ProductPrice() {
    }

    public ProductPrice(String sku, double MRP, PricingStrategy pricingStrategy) {
        this.sku = sku;
        this.MRP = MRP;
        this.pricingStrategy = pricingStrategy;

    }

    public double getMRP() {
        return MRP;
    }


    public double getSellingPrice() {

        return pricingStrategy.calculatePrice(this);
    }



    public double getDiscount() {
        return pricingStrategy.getDiscountPercent(this);
    }

    public double getDiscountAmount() {

        return  pricingStrategy.getDiscountAmount(this);
    }
}
