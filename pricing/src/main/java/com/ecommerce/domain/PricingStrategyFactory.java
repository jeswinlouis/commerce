package com.ecommerce.domain;

import com.ecommerce.domain.api.PricingType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeswin on 27/02/17.
 */
public class PricingStrategyFactory {


    private Map<PricingType, PricingStrategy> strategies = new HashMap<PricingType, PricingStrategy>();


    private PricingStrategyFactory() {
        PricingStrategy fixedPricing = new FixedPricingStrategy();
        PricingStrategy fixedDiscountPricing = new FixedDiscountPricingStrategy();
        PricingStrategy dynamicDiscountPricing = new DynamicDiscountPricingStrategy();

        strategies.put(PricingType.FIXED, fixedPricing);
        strategies.put(PricingType.FIXEDDISCOUNT, fixedDiscountPricing);
        strategies.put(PricingType.DYNAMICDISCOUNT, dynamicDiscountPricing);

    }

    private static class SingletonHolder {
        private static final PricingStrategyFactory INSTANCE = new PricingStrategyFactory();
    }


    public static PricingStrategyFactory getInstance() {

        return SingletonHolder.INSTANCE;

    }

    public PricingStrategy getStrategy(PricingType pricingType) {

        return strategies.get(pricingType);

    }
}
