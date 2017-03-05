package com.ecommerce.domain;

/**
 * Created by jeswin on 27/02/17.
 */
public interface PricingStrategy {
    public double calculatePrice(ProductPrice productPrice);

    public double getDiscountPercent(ProductPrice productPrice) ;

    public double getDiscountAmount(ProductPrice productPrice) ;

}
