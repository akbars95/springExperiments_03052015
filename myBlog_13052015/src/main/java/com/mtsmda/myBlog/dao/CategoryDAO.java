package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Category;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface CategoryDAO {

    public boolean saveOrUpdateCategory(Category category);

    public boolean deleteCategory(Integer categoryId);

    public Category getCategory(Integer categoryId);

    public List<Category> getAllCategory();

}