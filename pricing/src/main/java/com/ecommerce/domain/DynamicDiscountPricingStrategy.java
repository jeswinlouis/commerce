package com.ecommerce.domain;

import com.ecommerce.domain.api.PricingType;

import java.util.Random;

/**
 * Created by jeswin on 27/02/17.
 */
public class DynamicDiscountPricingStrategy extends BaseDiscountPricingStrategy {

    private static final int MAX_DISCOUNT = 80;

    private PricingType pricingType = PricingType.DYNAMICDISCOUNT;

    private double discount = new Random().nextInt(MAX_DISCOUNT);


    @Override
    public double calculatePrice(ProductPrice productPrice) {

        return getDiscountPrice(productPrice.getMRP(), getDiscountPercent(productPrice));
    }


    @Override
    public double getDiscountPercent(ProductPrice productPrice) {
        return discount;

    }

}
