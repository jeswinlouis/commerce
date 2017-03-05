package com.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;

/**
 * Created by jeswin on 11/02/17.
 */

@Entity
public class Category {

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long id;
    private String name;
    private URI image;



    private String description;


    Category() {}

    public Category(long id) {
        this.id = id;
    }
    public Category(String name) {

        this.name = name;

    }


    public long getId() {
        return id;
    }

    public URI getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }


    public String getName() {
        return this.name;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setImage(URI image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return name;
    }


}
