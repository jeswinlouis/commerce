package com.ecommerce.repository;

/**
 * Created by jeswin on 11/02/17.
 */

import com.ecommerce.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    public List<Category> findAll();
}
