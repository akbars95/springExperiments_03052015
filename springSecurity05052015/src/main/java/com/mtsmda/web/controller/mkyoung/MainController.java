package com.mtsmda.web.controller.mkyoung;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring Security");
        modelAndView.addObject("message", "This is welcome page!");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring Security");
        modelAndView.addObject("message", "This is protected page - Admin page!");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    public ModelAndView dbaPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring Security");
        modelAndView.addObject("message", "This is protected page - Database page!");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/update**", method = RequestMethod.GET)
    public ModelAndView updatePage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        if(isRememberMeAuthenticated()){
            setRememberMeTargetUrlToSession(request);
            modelAndView.addObject("loginUpdate", true);
            modelAndView.setViewName("/login");
        }else{
            modelAndView.setViewName("update");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(error != null){
            modelAndView.addObject("error", "Invalid username and password");
            String targetURL = getRememberMeTargetUrlFromSession(request);
            System.out.println(targetURL);
            if(StringUtils.hasText(targetURL)){
                modelAndView.addObject("targetURL", targetURL);
                modelAndView.addObject("loginUpdate", true);
            }
        }

        if(logout != null){
            modelAndView.addObject("msg", "You've been logged out successfully");
        }
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            modelAndView.addObject("username", userDetails.getUsername());
        }
        modelAndView.setViewName("403");
        return modelAndView;
    }

    private boolean isRememberMeAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return false;
        }
        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }

    private void setRememberMeTargetUrlToSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.setAttribute("targetUrl", "/admin/update");
        }
    }

    private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
        String targetUrl = "";

        HttpSession session = request.getSession(false);
        if(session != null){
            targetUrl = session.getAttribute("targetUrl") == null ? "" : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }

}
