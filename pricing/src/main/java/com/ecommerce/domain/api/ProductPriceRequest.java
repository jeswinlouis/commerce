package com.ecommerce.domain.api;

/**
 * Created by jeswin on 27/02/17.
 */
public class ProductPriceRequest {

    private String sku;

    private double MRP;
    private PricingType pricingType;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getMRP() {
        return MRP;
    }

    public void setMRP(double MRP) {
        this.MRP = MRP;
    }

    public PricingType getPricingType() {
        return pricingType;
    }

    public void setPricingType(PricingType pricingType) {
        this.pricingType = pricingType;
    }
}
