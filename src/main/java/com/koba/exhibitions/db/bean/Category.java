package com.koba.exhibitions.db.bean;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 3951976055201869261L;

    private Integer id;
    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
