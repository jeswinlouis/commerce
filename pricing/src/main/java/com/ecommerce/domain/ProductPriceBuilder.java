package com.ecommerce.domain;

import com.ecommerce.domain.api.ProductPriceRequest;

/**
 * Created by jeswin on 27/02/17.
 */
public class ProductPriceBuilder {


    private ProductPriceRequest productPriceRequest;


    public static ProductPriceBuilder aProductPriceBuilder(ProductPriceRequest productPriceRequest) {
        productPriceRequest = productPriceRequest;

        return new ProductPriceBuilder();
    }
    public ProductPrice build() {

        PricingStrategy pricingStrategy = PricingStrategyFactory.getInstance().getStrategy(productPriceRequest.getPricingType());

        return new ProductPrice(productPriceRequest.getSku(), productPriceRequest.getMRP(), pricingStrategy);
    }
}
