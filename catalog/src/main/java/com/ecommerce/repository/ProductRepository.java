package com.ecommerce.repository;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.Store;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeswin on 11/02/17.
 */

@Repository
//public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, QueryDslPredicateExecutor<Product> {
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    public List<Product> findAll();


    public Product findBySku(String sku);

    public List<Product> findByCategory(Category category);

    public List<Product> findByStore(Store store);
}
