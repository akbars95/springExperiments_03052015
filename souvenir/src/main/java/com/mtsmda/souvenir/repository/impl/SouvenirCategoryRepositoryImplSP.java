package com.mtsmda.souvenir.repository.impl;

import com.mtsmda.souvenir.repository.SouvenirCategoryRepository;
import com.mtsmda.souvenir.exception.SouvenirException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.sp.SouvenirStoredProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

import static com.mtsmda.souvenir.model.sp.SouvenirCategorySP.*;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@Service("souvenirCategoryRepository")
public class SouvenirCategoryRepositoryImplSP implements SouvenirCategoryRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    private SouvenirStoredProcedure souvenirStoredProcedure;

    @Override
    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory) {
        try {
            dataSource.getConnection().setAutoCommit(false);
            List<SqlParameter> sqlParameters = Arrays.asList(SOUVENIR_CATEGORY_IN_SP_SQL_PARAM);
            souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, INSERT_SOUVENIR_CATEGORY_SP_NAME, sqlParameters);

            List<String> keysList = new ArrayList<>();
            ListHelper.getList(keysList, new String[]{SOUVENIR_CATEGORY_IN_SP_PARAM_NAME});
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            MapHelper.getMap(stringObjectHashMap, keysList, souvenirCategory.getSouvenirCategory());
            Map map = souvenirStoredProcedure.executeSP(stringObjectHashMap);
            dataSource.getConnection().commit();
        } catch (Exception e) {
            try {
                dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new SouvenirException("Exception when insert new SouvenirCategory - " + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean updateSouvenirCategory(SouvenirCategory souvenirCategory) {
        try {
            dataSource.getConnection().setAutoCommit(false);
            List<SqlParameter> sqlParameters = Arrays.asList(SOUVENIR_CATEGORY_IN_SP_SQL_PARAM, SOUVENIR_CATEGORY_ID_IN_SP_SQL_PARAM);
            souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, UPDATE_SOUVENIR_CATEGORY_SP_NAME, sqlParameters);

            List<String> keysList = new ArrayList<>();
            ListHelper.getList(keysList, new String[]{SOUVENIR_CATEGORY_IN_SP_PARAM_NAME, SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME});
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            MapHelper.getMap(stringObjectHashMap, keysList, souvenirCategory.getSouvenirCategory(), souvenirCategory.getSouvenirCategoryId());
            Map map = souvenirStoredProcedure.executeSP(stringObjectHashMap);
            dataSource.getConnection().commit();
        } catch (Exception e) {
            try {
                dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new SouvenirException("Exception when update SouvenirCategory - " + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteSouvenirCategory(SouvenirCategory souvenirCategory) {
        try {
            dataSource.getConnection().setAutoCommit(false);
            List<SqlParameter> sqlParameters = Arrays.asList(SOUVENIR_CATEGORY_ID_IN_SP_SQL_PARAM);
            souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, DELETE_SOUVENIR_CATEGORY_SP_NAME, sqlParameters);

            List<String> keysList = new ArrayList<>();
            ListHelper.getList(keysList, new String[]{SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME});
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            MapHelper.getMap(stringObjectHashMap, keysList, souvenirCategory.getSouvenirCategoryId());
            Map map = souvenirStoredProcedure.executeSP(stringObjectHashMap);
            dataSource.getConnection().commit();
        } catch (Exception e) {
            try {
                dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new SouvenirException("Exception when delete SouvenirCategory - " + e.getMessage());
        }
        return true;
    }

    @Override
    public SouvenirCategory getSouvenirCategory(Integer souvenirCategoryId) {
        SouvenirCategory souvenirCategory = null;
        try {
            dataSource.getConnection().setAutoCommit(false);
            List<SqlParameter> sqlParameters = Arrays.asList(SOUVENIR_CATEGORY_ID_IN_SP_SQL_PARAM);
            souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, GET_SOUVENIR_CATEGORY_SP_NAME, sqlParameters);

            List<String> keysList = new ArrayList<>();
            ListHelper.getList(keysList, new String[]{SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME});
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            MapHelper.getMap(stringObjectHashMap, keysList, souvenirCategory.getSouvenirCategoryId());
            Map map = souvenirStoredProcedure.executeSP(stringObjectHashMap);
            dataSource.getConnection().commit();
        } catch (Exception e) {
            try {
                dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new SouvenirException("Exception when get SouvenirCategory - " + e.getMessage());
        }
        return souvenirCategory;
    }

    @Override
    public List<SouvenirCategory> getAllSouvenirCategories() {
        List<SouvenirCategory> souvenirCategories = null;
        try {
            dataSource.getConnection().setAutoCommit(false);
            souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, GET_ALL_SOUVENIR_CATEGORIES_SP_NAME, null);

            Map map = souvenirStoredProcedure.executeSP();
            dataSource.getConnection().commit();
        } catch (Exception e) {
            try {
                dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new SouvenirException("Exception when get all SouvenirCategory - " + e.getMessage());
        }
        return souvenirCategories;
    }
}