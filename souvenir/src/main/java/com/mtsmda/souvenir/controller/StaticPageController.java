package com.mtsmda.souvenir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticPageController {

	private static final String ROOT = "/";
	private static final String INDEX = "index";
	private static final String INDEX_URL = ROOT + INDEX;
	private static final String HOME_URL = ROOT + "home";

	private static final String CATALOG = "catalog";
	private static final String CATALOG_URL = ROOT + CATALOG;

	private static final String ADVANCED_SEARCH = "advanced_search";
	private static final String ADVANCED_SEARCH_URL = ROOT + ADVANCED_SEARCH;

	private static final String ABOUT_US = "about_us";
	private static final String ABOUT_US_URL = ROOT + ABOUT_US;
	
	private static final String CONTACT_US = "contact_us";
	private static final String CONTACT_US_URL = ROOT + CONTACT_US;

	@RequestMapping(value = { ROOT, HOME_URL, INDEX_URL }, method = RequestMethod.GET)
	public String indexPage() {
		return INDEX;
	}

	@RequestMapping(value = { CATALOG_URL }, method = RequestMethod.GET)
	public String catalogPage() {
		return CATALOG;
	}

	@RequestMapping(value = { ADVANCED_SEARCH_URL }, method = RequestMethod.GET)
	public String advancedSearchPage() {
		return ADVANCED_SEARCH;
	}

	@RequestMapping(value = { ABOUT_US_URL }, method = RequestMethod.GET)
	public String aboutUsPage() {
		return ABOUT_US;
	}
	
	@RequestMapping(value = { CONTACT_US_URL }, method = RequestMethod.GET)
	public String contactUsPage() {
		return CONTACT_US;
	}


}
