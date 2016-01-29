package com.mtsmda.book_library.web.domain.repository;

import java.util.List;

import com.mtsmda.book_library.web.domain.Book;

public interface BookRepository {
	
	public void addBook(Book book);
	public void updateBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Integer bookId);
	
}