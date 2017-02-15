package com.ecommerce.controller;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Country;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.Store;
import com.ecommerce.service.CommonEntityService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeswin on 11/02/17.
 */

@RestController
public class CatalogController {



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
        System.out.println("Calling categories");

            return commonEntityService.getAllCategories(pageable);
     }

    @GetMapping("/products")
    public Page<Product> getProducts(Pageable pageable) {

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


    @PostMapping("products")
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

}
