package com.ecommerce.service.impl;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Country;
import com.ecommerce.domain.Store;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.CountryRepository;
import com.ecommerce.repository.StoreRepository;
import com.ecommerce.service.CommonEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by jeswin on 11/02/17.
 */

@Service
public class CommonEntityServiceImpl implements CommonEntityService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private CountryRepository countryRepository;



    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Country> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Page<Store> getAllStores(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }
}
