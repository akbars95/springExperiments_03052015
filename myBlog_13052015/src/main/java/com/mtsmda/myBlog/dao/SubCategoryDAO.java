package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.SubCategory;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface SubCategoryDAO {

    public boolean saveOrUpdateSubCategory(SubCategory subCategory);

    public boolean deleteSubCategory(Integer subCategoryId);

    public SubCategory getSubCategory(Integer subCategoryId);

    public List<SubCategory> getAllSubCategory();

}