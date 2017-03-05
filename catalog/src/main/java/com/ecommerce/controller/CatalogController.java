package com.ecommerce.controller;

import com.ecommerce.domain.*;
import com.ecommerce.service.CommonEntityService;
import com.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeswin on 11/02/17.
 */

@RestController
public class CatalogController {

    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    private CommonEntityService commonEntityService;



    @Autowired
    private ProductService productService;



    public void setCategoryService(CommonEntityService commonEntityService) {
        this.commonEntityService = commonEntityService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/countries")
    public Page<Country> getCountries(Pageable pageable) {

        return commonEntityService.getAllCountries(pageable);
    }

    @GetMapping("/stores")
    public Page<Store> getStores(Pageable pageable) {

        return commonEntityService.getAllStores(pageable);
    }

    @GetMapping("/categories")
    public Page<Category> getCategories(Pageable pageable) {
        LOG.debug("Calling categories");

            return commonEntityService.getAllCategories(pageable);
     }

    @GetMapping("/products")
    public Page<Product> getProducts(Pageable pageable) {

        LOG.debug("Calling service layer get Products methods");
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/products/{productId}")
    public Product getProducts(@PathVariable long productId) {

        return productService.getProduct(productId);
    }


    @GetMapping("/products/sku={sku}")
    public Product getProducts(@PathVariable String sku) {

        return productService.getProduct(sku);
    }


    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequest productRequest) {
       Product newProduct =  productService.addProduct(productRequest);
       System.out.println("Creating new product " + newProduct);

       LOG.debug("Newly created product " + newProduct );

       return newProduct;

    }

}
