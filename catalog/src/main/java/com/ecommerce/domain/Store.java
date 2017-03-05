package com.ecommerce.domain;

import javax.persistence.*;

/**
 * Created by jeswin on 12/02/17.
 */

@Entity
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "STORE_ID")
    private long id;


    private String name;



    Store() {

    }

    public Store(long id) {
        this.id = id;
    }

    public Store(String store) {
        this.name = store;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public long getId() {
        return id;
    }
}
