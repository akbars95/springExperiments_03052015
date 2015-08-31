package com.mtsmda.web.controller;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import com.mtsmda.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by MTSMDA on 03.08.2015.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping(value = "/products/{category}")
    public String getProductsByCategory(Model model, @PathVariable(value = "category") String productCategory) {

        model.addAttribute("products", productService.getProductByCategory(productCategory));

        return "products";
    }

    @RequestMapping(value = "/filter/{ByCriteria}")
    public String getProductsByFIlter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping(value = "/filter/{ByCriteria}/{Price}")
    public String getProductsByFIlterAndPrice(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, @MatrixVariable(pathVar = "Price") Map<String, List<String>> filterPrice, Model model) {
        List<Map<String, List<String>>> filtersList = new ArrayList<Map<String, List<String>>>();
        filtersList.add(filterParams);
        filtersList.add(filterPrice);
        model.addAttribute("products", productService.getProductsByFilterAndPrice(filtersList));
        return "products";
    }

    @RequestMapping(value = "/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductByID(productId));
        return "product";
    }

    @RequestMapping(value = "/productByIdAndCategory")
    public String getProductById2Param(@RequestParam("id") String productId, @RequestParam("category") String category, Model model) {
        Set<Product> productSet = new HashSet<Product>();
        productSet.add(productService.getProductByID(productId));
        productSet.add(productService.getProductByCategory(category).get(0));

        model.addAttribute("product", productSet.iterator().next());
        return "product";
    }

    @RequestMapping(value = "/products/{category}/{Price}")
    public String getProductsByCategoryPriceManufacturer(Model model, @PathVariable(value = "category") String productCategory, @MatrixVariable(pathVar = "Price") Map<String, List<String>> filterPrice, @RequestParam("manufacturer") String manufacturer) {
        Set<Product> returnResult = new HashSet<Product>();
        returnResult.addAll(productService.getProductByCategory(productCategory));
        returnResult.retainAll(productService.getProductsByManufacturer(manufacturer));
        returnResult.retainAll(productService.getProductBetweenPrice(filterPrice));

        model.addAttribute("products", returnResult);

        return "products";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model){
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product product, BindingResult bindingResult, HttpServletRequest request){
        String [] suppressedFields = bindingResult.getSuppressedFields();
        if(suppressedFields.length > 0){
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("\\resources\\images\\products\\" + product.getProductId() + ".png");
        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(rootDirectory + "\\"));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        productService.addProduct(product);
        return "redirect:/products";
    }

    @InitBinder()
    public void initialiseBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("unitsInOrder" ,"addDate", "productImage");
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, false);
        webDataBinder.registerCustomEditor(Date.class, customDateEditor);
    }
}