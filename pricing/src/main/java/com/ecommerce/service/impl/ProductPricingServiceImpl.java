package com.ecommerce.service.impl;

import com.ecommerce.domain.ProductPrice;
import com.ecommerce.domain.ProductPriceBuilder;
import com.ecommerce.domain.api.ProductPriceRequest;
import com.ecommerce.repository.ProductPricingRepository;
import com.ecommerce.service.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeswin on 27/02/17.
 */

@Service
public class ProductPricingServiceImpl implements ProductPricingService {

    @Autowired
    private ProductPricingRepository productPricingRepository;


    @Override
    public ProductPrice getPricing(String sku) {

        return productPricingRepository.findBySku(sku);

    }

    @Override
    public ProductPrice postPrice(ProductPriceRequest productPriceRequest) {

        ProductPrice price = ProductPriceBuilder.aProductPriceBuilder(productPriceRequest)
                .build();
        return null;
    }
}
