package com.ecommerce.service;

import com.ecommerce.domain.Product;
import com.ecommerce.domain.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jeswin on 11/02/17.
 */
public interface ProductService {
    public Page<Product> getAllProducts(Pageable pageable);

    public Product addProduct(ProductRequest productRequest);

    public Product getProduct(long id);

    public Product getProduct(String sku);

}
