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
@Table(name = "book_languages")
public class BookLanguage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "book_language_id", nullable = false, unique = true)
	private Integer bookLanguageId;

	@Column(name = "book_language", nullable = false, unique = true, length = 50)
	private String bookLanguage;

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookLanguage")
	private Set<Book> books = new HashSet<Book>();
*/
	public BookLanguage() {

	}

	public BookLanguage(String bookLanguage) {
		setBookLanguage(bookLanguage);
	}

	public Integer getBookLanguageId() {
		return bookLanguageId;
	}

	public void setBookLanguageId(Integer bookLanguageId) {
		this.bookLanguageId = bookLanguageId;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	/*public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookLanguage == null) ? 0 : bookLanguage.hashCode());
		result = prime * result + ((bookLanguageId == null) ? 0 : bookLanguageId.hashCode());
		//result = prime * result + ((books == null) ? 0 : books.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLanguage other = (BookLanguage) obj;
		if (bookLanguage == null) {
			if (other.bookLanguage != null)
				return false;
		} else if (!bookLanguage.equals(other.bookLanguage))
			return false;
		if (bookLanguageId == null) {
			if (other.bookLanguageId != null)
				return false;
		} else if (!bookLanguageId.equals(other.bookLanguageId))
			return false;
		/*if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;*/
		return true;
	}

	@Override
	public String toString() {
		return "BookLanguage [bookLanguageId=" + bookLanguageId + ", bookLanguage=" + bookLanguage + ", books=" //+ books
				+ "]";
	}

}