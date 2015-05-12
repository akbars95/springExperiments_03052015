package com.mtsmda.blog.service;

import com.mtsmda.blog.bd.dao.CategoryDAO;
import com.mtsmda.blog.bd.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dmitriim on 5/12/2015.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public boolean save(Category category) {
        return categoryDAO.save(category);
    }

    @Transactional
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Transactional
    public boolean delete(Category category) {
        return categoryDAO.delete(category);
    }

    @Transactional
    public List<Category> categories() {
        return categoryDAO.categories();
    }

    @Transactional
    public Category getCategory(Category category) {
        return categoryDAO.getCategory(category);
    }
}