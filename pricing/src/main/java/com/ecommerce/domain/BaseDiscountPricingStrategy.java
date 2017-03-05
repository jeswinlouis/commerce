package com.ecommerce.domain;

/**
 * Created by jeswin on 27/02/17.
 */
public abstract class BaseDiscountPricingStrategy implements PricingStrategy {

    public double getDiscountPrice(double MRP, double discount) {
        return MRP - (MRP * discount)/ 100 ;
    }
    public double getDiscountPercent(ProductPrice productPrice) {
        return 0.0;
    }

    public double getDiscountAmount(ProductPrice productPrice) {
        return productPrice.getMRP() - calculatePrice(productPrice);
    }
}
