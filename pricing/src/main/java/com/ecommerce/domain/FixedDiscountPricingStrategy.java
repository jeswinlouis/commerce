package com.ecommerce.domain;

/**
 * Created by jeswin on 27/02/17.
 */
public class FixedDiscountPricingStrategy extends BaseDiscountPricingStrategy {


    private static final double FIXEDDSICOUNT = 10;


    private PricingType pricingType = PricingType.FIXEDDISCOUNT;

    @Override
    public double calculatePrice(ProductPrice productPrice) {

        return getDiscountPrice(productPrice.getMRP(), FIXEDDSICOUNT);
    }

    @Override
    public double getDiscountPercent(ProductPrice productPrice) {
        return FIXEDDSICOUNT;
    }
}
