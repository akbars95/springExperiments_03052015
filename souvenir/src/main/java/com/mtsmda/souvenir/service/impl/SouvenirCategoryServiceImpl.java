package com.mtsmda.souvenir.service.impl;

import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.repository.SouvenirCategoryRepository;
import com.mtsmda.souvenir.service.SouvenirCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@Service("souvenirCategoryService")
public class SouvenirCategoryServiceImpl implements SouvenirCategoryService {

    @Autowired
    @Qualifier("souvenirCategoryDAO")
    private SouvenirCategoryRepository souvenirCategoryDAO;

    @Override
    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory) {
        return souvenirCategoryDAO.insertSouvenirCategory(souvenirCategory);
    }

    @Override
    public boolean updateSouvenirCategory(SouvenirCategory souvenirCategory) {
        return souvenirCategoryDAO.updateSouvenirCategory(souvenirCategory);
    }

    @Override
    public boolean deleteSouvenirCategory(SouvenirCategory souvenirCategory) {
        return souvenirCategoryDAO.deleteSouvenirCategory(souvenirCategory);
    }

    @Override
    public SouvenirCategory getSouvenirCategory(Integer souvenirCategoryId) {
        return souvenirCategoryDAO.getSouvenirCategory(souvenirCategoryId);
    }

    @Override
    public List<SouvenirCategory> getAllSouvenirCategories() {
        return souvenirCategoryDAO.getAllSouvenirCategories();
    }
}