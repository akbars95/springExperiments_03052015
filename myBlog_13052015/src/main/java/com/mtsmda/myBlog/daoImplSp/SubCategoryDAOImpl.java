package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.SubCategoryDAO;
import com.mtsmda.myBlog.model.SubCategory;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class SubCategoryDAOImpl implements SubCategoryDAO {

    @Override
    public boolean saveOrUpdateSubCategory(SubCategory subCategory) {
        return false;
    }

    @Override
    public boolean deleteSubCategory(Integer subCategoryId) {
        return false;
    }

    @Override
    public SubCategory getSubCategory(Integer subCategoryId) {
        return null;
    }

    @Override
    public List<SubCategory> getAllSubCategory() {
        return null;
    }

}