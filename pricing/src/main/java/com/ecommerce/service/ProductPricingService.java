package com.ecommerce.service;

import com.ecommerce.domain.ProductPrice;
import com.ecommerce.domain.api.ProductPriceRequest;

/**
 * Created by jeswin on 27/02/17.
 */
public interface ProductPricingService {

    public ProductPrice getPricing(String sku);

    ProductPrice postPrice(ProductPriceRequest productPriceRequest);
}
