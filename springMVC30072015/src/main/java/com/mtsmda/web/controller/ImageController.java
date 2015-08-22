package com.mtsmda.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/images", method = RequestMethod.GET)
public class ImageController {
	
	private List<String> images = new ArrayList<>();
	private List<String> imageNames = new ArrayList<>();
	
	public ImageController(){
		images.add(IMAGE_RESOURCES_PATH + "Hibernate.png");
		imageNames.add("Hibernate.png");
		images.add(IMAGE_RESOURCES_PATH + "Java-persistence.PNG");
		imageNames.add("Java-persistence.PNG");
		images.add(IMAGE_RESOURCES_PATH + "spring-by-pivotal.png");
		imageNames.add("spring-by-pivotal.png");
	}
	
	private static final String IMAGE_RESOURCES_PATH = "/resources/images/";
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)	
	public String getImages(Model model){
		model.addAttribute("images", images);
		return "images";
	}
	
	@RequestMapping(value = "/image/{imageName}", method = RequestMethod.GET)	
	public String getImage(Model model, @PathVariable(value = "imageName") String name){
		String temp = searchImage(name);
		if(temp == null){
			return "redirect:/images";	
		}
		model.addAttribute("image", temp);
		return "image";
	}
	
	private String searchImage(String name){
		if(images.contains(name)){
			return imageNames.get(images.indexOf(name));
		}
		return null;
	}
	
}