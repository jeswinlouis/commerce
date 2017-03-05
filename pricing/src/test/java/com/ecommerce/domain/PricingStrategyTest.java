package com.ecommerce.domain;

import com.ecommerce.domain.api.PricingType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jeswin on 27/02/17.
 */

public class PricingStrategyTest {


    String sku = "123";
    double MRP = 200.0;

    PricingStrategyFactory pricingStrategyFactory;

    @Before
    public void setup() {
        pricingStrategyFactory = PricingStrategyFactory.getInstance();

    }


    @Test
    public void testFixedPricingStrategy() {

        ProductPrice productPrice = new ProductPrice(sku, MRP, pricingStrategyFactory.getStrategy(PricingType.FIXED));


        assertThat(productPrice.getSellingPrice(), is(200.0));
        assertThat(productPrice.getDiscount(), is(0.0));
        assertThat(productPrice.getDiscountAmount(), is(0.0));

    }

    @Test
    public void testFixedDiscountPricingStrategy() {

        ProductPrice productPrice = new ProductPrice(sku, MRP, pricingStrategyFactory.getStrategy(PricingType.FIXEDDISCOUNT));


        assertThat(productPrice.getSellingPrice(), is(180.0));
        assertThat(productPrice.getDiscount(), is(10.0));

        assertThat(productPrice.getDiscountAmount(), is(20.0));

    }

    @Test
    public void testDynamicDiscountPricingStrategy() {

        ProductPrice productPrice = new ProductPrice(sku, MRP, pricingStrategyFactory.getStrategy(PricingType.DYNAMICDISCOUNT));

        assertThat(productPrice.getDiscountAmount(), is(productPrice.getMRP() - productPrice.getSellingPrice()));

    }



}