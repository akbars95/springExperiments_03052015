package com.mtsmda.myBlog.model;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class Category {

    private Integer idCategory;
    private String categoryName;
    private String categoryDescription;

    public Category() {

    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}