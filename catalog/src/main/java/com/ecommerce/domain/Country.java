package com.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeswin on 12/02/17.
 */

@Entity
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "COUNTRY_ID")
    private long id;

    private String name;

    Country() {}

    public Country(String name) {

        this.name = name;
    }

    public String getCountry() {
        return name;
    }

}
