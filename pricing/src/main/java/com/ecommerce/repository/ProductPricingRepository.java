package com.ecommerce.repository;

import com.ecommerce.domain.ProductPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeswin on 27/02/17.
 */

@Repository
public interface ProductPricingRepository extends CrudRepository<ProductPrice, Long> {
    public ProductPrice findBySku(String sku);

}
