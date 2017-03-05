package com.ecommerce.repository;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Country;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * Created by jeswin on 25/02/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testFindAll() {



        Page<Product> products = productRepository.findAll(createPageRequest());

        assertThat(products.getSize(), is(20));

    }

    @Test
    public void testSaveProduct() {

        Product p = new Product("123", "new Product", "description", new Category(2), new Store(3), new Country(1));


        Product newProduct = productRepository.save(p);

        assertEquals(p.getSku(), newProduct.getSku());

    }

    public Pageable createPageRequest() {

        return new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 20;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };

    }
}
