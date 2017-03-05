package com.ecommerce.domain;

import com.ecommerce.domain.api.PricingType;

/**
 * Created by jeswin on 27/02/17.
 */
public class FixedPricingStrategy extends BaseDiscountPricingStrategy {

    private  PricingType pricingType = PricingType.FIXED;

    @Override
    public double calculatePrice(ProductPrice productPrice) {
        return productPrice.getMRP();
    }


}
