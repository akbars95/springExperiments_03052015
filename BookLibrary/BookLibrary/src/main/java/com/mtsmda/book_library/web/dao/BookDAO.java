package com.mtsmda.book_library.web.dao;

import java.util.List;

import com.mtsmda.book_library.web.model.Book;

public interface BookDAO {
	
	public void addBook(Book book);
	public void updateBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Integer bookId);
	
}