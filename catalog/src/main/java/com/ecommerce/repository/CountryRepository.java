package com.ecommerce.repository;

import com.ecommerce.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jeswin on 12/02/17.
 */
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
