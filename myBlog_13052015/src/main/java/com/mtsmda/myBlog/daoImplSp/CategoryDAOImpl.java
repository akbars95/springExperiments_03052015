package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.CategoryDAO;
import com.mtsmda.myBlog.model.Category;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public boolean saveOrUpdateCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(Integer categoryId) {
        return false;
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return null;
    }

}