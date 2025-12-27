package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Book;

public interface BookService {

    Book addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book updateBook(int id, Book book);

    List<Book> getBooksByCategoryName(String categoryName);

    List<Book> getBooksByTitle(String title);
}
