package com.ecommerce.repository;

import com.ecommerce.domain.Store;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jeswin on 12/02/17.
 */
public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {
}
