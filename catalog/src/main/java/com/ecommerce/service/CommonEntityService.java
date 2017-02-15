package com.ecommerce.service;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Country;
import com.ecommerce.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jeswin on 11/02/17.
 */
public interface CommonEntityService {
    Page<Category> getAllCategories(Pageable pageable);
    Page<Country> getAllCountries(Pageable pageable);
    Page<Store> getAllStores(Pageable pageable);



}
