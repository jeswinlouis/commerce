package com.ecommerce.service.impl;

import com.ecommerce.domain.Product;
import com.ecommerce.domain.ProductBuilder;
import com.ecommerce.domain.ProductRequest;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by jeswin on 11/02/17.
 */

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {

        LOG.debug("Calling repository layer find ALL method");

        Page<Product> products =  productRepository.findAll(pageable);

        LOG.debug(" total product found : " + products.getSize());

        return products;
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {

        Product product = ProductBuilder.aProductBuilder()
                .forSku(productRequest.getSku())
                .withName(productRequest.getName())
                .withDescription(productRequest.getDescription())
                .inCategory(productRequest.getCategory())
                .country(productRequest.getCountry())
                .inStore(productRequest.getStore())
                .build();

        Product newProduct =  productRepository.save(product);


        return newProduct;

    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product getProduct(String sku) {
        return productRepository.findBySku(sku);
    }
}
