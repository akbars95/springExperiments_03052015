package com.mtsmda.myBlog.controller;

import com.mtsmda.myBlog.dao.ArticleDAO;
import com.mtsmda.myBlog.model.Article;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.mtsmda.myBlog.utils.constants.PageNameUtil.GET_ALL_TUTORIALS_REAL;
import static com.mtsmda.myBlog.utils.constants.PageNameUtil.GET_TUTORIAL_REAL;
import static com.mtsmda.myBlog.utils.constants.PageNameUtil.TUTORIAL_DETAIL_PAGE;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
@RestController
public class TutorialController {

    private static final Logger logger = Logger.getLogger(TutorialController.class);

    @Autowired
    private ArticleDAO articleDAO;

    @RequestMapping(value = GET_ALL_TUTORIALS_REAL, method = RequestMethod.GET, produces = {"application/json"})
    public List<Article> getAllTutorials(){
        logger.info("input to List<Article> getAllTutorials() method");
        List<Article> articles = null;

        articles = articleDAO.getAllArticle();
        logger.info(articles.size() + " articles");

        return articles;
    }

    @RequestMapping(value = GET_TUTORIAL_REAL + "/{articleIdIn}", method = RequestMethod.GET)
    public String getTutorial(@PathVariable("articleIdIn") String articleIdIn){
        logger.info("input to  Article getTutorial() method");
        Article article = null;

        Integer articleId = Integer.parseInt(articleIdIn);

        article = articleDAO.getArticle(articleId);
        logger.info((article != null) + " article");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article", article);

        return TUTORIAL_DETAIL_PAGE;
    }

}