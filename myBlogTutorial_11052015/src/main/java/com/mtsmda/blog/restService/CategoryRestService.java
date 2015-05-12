package com.mtsmda.blog.restService;

import com.mtsmda.blog.bd.model.Category;
import com.mtsmda.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by dmitriim on 5/12/2015.
 */
@Path(value = "service")
public class CategoryRestService {

    @Autowired
    private CategoryService categoryService;

    @GET
    @Path("json/category/{categoryId}")
    @Produces("application/json")
    public Category getCategoryJSON(@PathParam("categoryId") Integer categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        Category resultCategory = categoryService.getCategory(category);
        return resultCategory;
    }

}
