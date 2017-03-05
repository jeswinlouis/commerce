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
    @Column(name = "COUNTRY_ID", nullable = false)
    private long id;

    @Column(name ="name", nullable = false )
    private String name;

    Country() {}

    public Country(long id) {
        this.id = id;
    }

    public Country(String name) {

        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return name;
    }

    public String toString() {

        return name;
    }
}
