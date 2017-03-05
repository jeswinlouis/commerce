package com.ecommerce.service;

import com.ecommerce.domain.*;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by jeswin on 05/03/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService = new ProductServiceImpl();

    private Product product;
    private ProductRequest productRequest = new ProductRequest();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(productService);

        String sku = "123";
        String name = "New Product";
        String description = "This is a product description";
        float amount = 100;

        long category = 1;
        long country = 1;
        long store = 1;


        productRequest.setSku(sku);
        productRequest.setName(name);
        productRequest.setDescription(description);
        productRequest.setAmount(amount);
        productRequest.setCategory(category);
        productRequest.setCountry(country);
        productRequest.setStore(store);

        product = new Product(sku, name, description, new Category(category), new Store(store), new Country(country));
        when(productRepository.save(any(Product.class))).thenReturn(product);

    }


    @Test
    public void addProduct() throws Exception {


        Product newProduct =  productService.addProduct(productRequest);

        assertEquals(product.getSku(), newProduct.getSku());


    }

}