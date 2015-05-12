package com.mtsmda.blog.service;

import com.mtsmda.blog.bd.model.Category;

import java.util.List;

/**
 * Created by dmitriim on 5/12/2015.
 */
public interface CategoryService {

    public boolean save(Category category);

    public boolean update(Category category);

    public boolean delete(Category category);

    public List<Category> categories();

    public Category getCategory(Category category);
}
