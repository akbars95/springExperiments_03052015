package com.mtsmda.book_library.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_sub_categories")
public class BookSubCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_sub_category_id", nullable = false, unique = true)
	private Integer bookSubCategoryId;

	@Column(name = "book_sub_category_name", nullable = false, unique = true)
	private String bookSubCategoryName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookSubCategory")
	private Set<BookCategory> bookCategories = new HashSet<BookCategory>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookSubCategory")
	private Set<Book> books = new HashSet<Book>();

	public BookSubCategory() {

	}

	public BookSubCategory(String bookSubCategoryName) {

	}

}