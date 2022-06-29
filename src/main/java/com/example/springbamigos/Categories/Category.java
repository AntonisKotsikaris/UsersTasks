package com.example.springbamigos.Categories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "Categories")
public class Category {

    @Id
    @Column(name = "ID")
    private long id;

    @Column ( name = "CategorieTitle")
    private String categoryTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categorieTitle) {
        this.categoryTitle = categorieTitle;
    }
}
