package com.ecommerce.controller;

import com.ecommerce.domain.ProductPrice;
import com.ecommerce.domain.api.ProductPriceRequest;
import com.ecommerce.service.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeswin on 27/02/17.
 */

@RestController
public class PricingController {

    @Autowired
    ProductPricingService productPricingService;


    @GetMapping("/pricing/{sku}")
    public ProductPrice getProductPrice(@PathVariable String sku) {

        return productPricingService.getPricing(sku);
    }

    @PostMapping("/pricing")
    public ProductPrice addPricing(@RequestBody ProductPriceRequest productPriceRequest) {

        return productPricingService.postPrice(productPriceRequest);
    }
}
