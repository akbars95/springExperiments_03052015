package com.mtsmda.blog.test;

import com.mtsmda.blog.bd.model.Category;
import com.mtsmda.blog.bd.model.SubCategory;
import com.mtsmda.blog.bd.dao.CategoryDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dmitriim on 5/12/2015.
 */
public class SpringHibernateTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("-----spring.xml");
        System.out.println(context == null);
        CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);
        Category category = new Category();
        category.setCategoryName("Programming languages");
        category.setCategoryDescription("Different Programming languages tutorial");

        SubCategory subCategoryJava = new SubCategory();
        subCategoryJava.setSubCategoryName("Java");
        subCategoryJava.setSubCategoryDescription("Java Programming language");
        subCategoryJava.setCategory(category);

        SubCategory subCategoryDotNET = new SubCategory();
        subCategoryDotNET.setSubCategoryName("C#,.NET");
        subCategoryDotNET.setSubCategoryDescription("C#,.NET Programming language");
        subCategoryDotNET.setCategory(category);

        category.getSubCategories().add(subCategoryJava);
        category.getSubCategories().add(subCategoryDotNET);

        categoryDAO.save(category);
        System.out.println("OK");
    }

}
