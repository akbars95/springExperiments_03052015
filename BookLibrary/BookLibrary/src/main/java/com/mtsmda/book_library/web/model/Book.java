package com.mtsmda.book_library.web.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false, unique = true)
	private Integer bookId;
	
	@Column(name = "book_title", nullable = false, length = 50)
	private String bookTitle;
	
	@Column(name = "book_title", nullable = false, length = 13)
	private String bookISBN;
	
	@Column(name = "book_year")
	private Integer bookYear;
	
	@Column(name = "book_count_page", nullable = false)
	private Integer bookCountPage;
	
	@Column(name = "book_file_size")
	private Double bookFileSize;
	
	@Column(name = "book_description", length = 500)
	private String bookDescription;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_publisher_id", nullable = false)
	private Publisher publisher;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_language_id", nullable = false)
	private BookLanguage bookLanguage;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_file_format_id", nullable = false)
	private FileFormat fileFormat;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_sub_category_id", nullable = false)
	private BookSubCategory bookSubCategory;
	
	public Book() {
		
	}
	
	
	
	
	
}