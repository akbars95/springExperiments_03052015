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

	public Integer getBookSubCategoryId() {
		return bookSubCategoryId;
	}

	public void setBookSubCategoryId(Integer bookSubCategoryId) {
		this.bookSubCategoryId = bookSubCategoryId;
	}

	public String getBookSubCategoryName() {
		return bookSubCategoryName;
	}

	public void setBookSubCategoryName(String bookSubCategoryName) {
		this.bookSubCategoryName = bookSubCategoryName;
	}

	public Set<BookCategory> getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(Set<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BookSubCategory that = (BookSubCategory) o;

		if (bookSubCategoryId != null ? !bookSubCategoryId.equals(that.bookSubCategoryId) : that.bookSubCategoryId != null)
			return false;
		if (bookSubCategoryName != null ? !bookSubCategoryName.equals(that.bookSubCategoryName) : that.bookSubCategoryName != null)
			return false;
		if (bookCategories != null ? !bookCategories.equals(that.bookCategories) : that.bookCategories != null)
			return false;
		return !(books != null ? !books.equals(that.books) : that.books != null);

	}

	@Override
	public int hashCode() {
		int result = bookSubCategoryId != null ? bookSubCategoryId.hashCode() : 0;
		result = 31 * result + (bookSubCategoryName != null ? bookSubCategoryName.hashCode() : 0);
		result = 31 * result + (bookCategories != null ? bookCategories.hashCode() : 0);
		result = 31 * result + (books != null ? books.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BookSubCategory{" +
				"bookSubCategoryId=" + bookSubCategoryId +
				", bookSubCategoryName='" + bookSubCategoryName + '\'' +
				", bookCategories=" + bookCategories +
				", books=" + books +
				'}';
	}
}