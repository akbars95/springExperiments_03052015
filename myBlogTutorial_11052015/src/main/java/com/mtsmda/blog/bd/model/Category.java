package com.mtsmda.blog.bd.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MTSMDA on 11.05.2015.
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements java.io.Serializable{

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CATEGORY_NAME", length = 150, nullable = false, unique = true)
    private String categoryName;

    @Column(name = "CATEGORY_DESCRIPTION", length = 255, nullable = true)
    private String categoryDescription;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SubCategory> subCategories;

    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}