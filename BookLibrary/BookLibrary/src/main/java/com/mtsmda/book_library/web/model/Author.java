package com.mtsmda.book_library.web.model;

import java.io.Serializable;

public class Author implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer authorId;
	private String authorFirstName;
	private String authorLastName;
	private String authorMiddleName;
	
	public Author() {
		
	}
	
}