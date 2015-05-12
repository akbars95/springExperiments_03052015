package com.mtsmda.blog.bd.model;

/**
 * Created by MTSMDA on 11.05.2015.
 */
public class SubCategory implements java.io.Serializable{

    private Integer subCategoryId;
    private Category category;
    private String subCategoryName;
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
