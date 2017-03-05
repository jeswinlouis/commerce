package com.ecommerce.controller;

import com.ecommerce.domain.*;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.CountryRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.StoreRepository;
import com.ecommerce.service.CommonEntityService;
import com.ecommerce.service.ProductService;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by jeswin on 25/02/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(CatalogController.class)
@EnableSpringDataWebSupport
public class CatalogControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CommonEntityService entity;

    @MockBean
    private ProductService productService;


    @MockBean
    CountryRepository countryRepository;

    @MockBean
    StoreRepository storeRepository;

    @MockBean
    CategoryRepository categoryRepository;

    @MockBean
    ProductRepository productRepository;



    @Test
    public void testGetCountries() throws Exception {


        Faker faker = new Faker();
        String[] countryList = { "North America", "Germany", "South Africa"};


        Page countryPage = new PageImpl(Arrays.asList(countryList));

        given(this.entity.getAllCountries(any(Pageable.class)))
                .willReturn(countryPage);


        this.mvc.perform(get("/countries").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.content",hasSize(3)))
                .andExpect(jsonPath("$.content[*]",containsInAnyOrder("North America", "Germany", "South Africa")))
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(3))
                .andExpect(jsonPath("$.numberOfElements").value(3))

        ;

    }

    @Test
    public void testNewProduct() throws Exception {

        String sku = "697-91-8077";
        String productName = "Awesome Copper Watch Marble Ajax ";
        String description = " the prouct descritpion ";
        long category = 1;
        long store = 1;
        long country = 1;

        ProductRequest productRequest = new ProductRequest();
        productRequest.setSku(sku);
        productRequest.setName(productName);
        productRequest.setDescription(description);
        productRequest.setCategory(category);
        productRequest.setStore(store);
        productRequest.setCountry(country);

        Product p = new Product(sku, productName, description, new Category(category), new Store(store), new Country(country) );

        String productData = new Gson().toJson(productRequest);

        System.out.println(" the json product request is " + productData);

        given(productService.addProduct(any(ProductRequest.class))).willReturn(p);


        this.mvc.perform(post("/products")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(productData))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sku").value("697-91-8077"))


        ;
    }

}
