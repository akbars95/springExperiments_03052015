package com.mtsmda.blog.bd.model;

import javax.persistence.*;

/**
 * Created by MTSMDA on 11.05.2015.
 */
@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategory implements java.io.Serializable{

    @Id
    @GeneratedValue
    @Column(name = "SUB_CATEGORY_ID")
    private Integer subCategoryId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name = "SUB_CATEGORY_NAME", length = 150, nullable = false, unique = true)
    private String subCategoryName;

    @Column(name = "SUB_CATEGORY_DESCRIPTION", length = 255, nullable = true)
    private String subCategoryDescription;

    public SubCategory() {

    }

    public SubCategory(String subCategoryName, String subCategoryDescription) {
        this.subCategoryName = subCategoryName;
        this.subCategoryDescription = subCategoryDescription;
    }

    public SubCategory(Category category, String subCategoryName, String subCategoryDescription) {
        this.category = category;
        this.subCategoryName = subCategoryName;
        this.subCategoryDescription = subCategoryDescription;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryDescription() {
        return subCategoryDescription;
    }

    public void setSubCategoryDescription(String subCategoryDescription) {
        this.subCategoryDescription = subCategoryDescription;
    }
}
