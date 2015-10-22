package com.mtsmda.book_library.web.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "book_categories")
public class BookCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_category_id", nullable = false, unique = true)
	private Integer bookCategoryId;
	
	@Column(name = "book_category_name", nullable = false, unique = true)
	private String bookCategoryName;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_category_id", nullable = false)
	private BookSubCategory bookSubCategory;
	
	public BookCategory() {
		
	}
	
	
}