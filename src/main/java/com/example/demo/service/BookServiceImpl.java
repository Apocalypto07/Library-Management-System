package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.examly.springapp.model.Book;

@Service
public class BookServiceImpl implements BookService {

    private static List<Book> books = new ArrayList<>();
    private static long idCounter = 1;

    @Override
    public Book addBook(Book book) {
        book.setBookId(idCounter++);
        books.add(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(int id) {
        return books.stream()
                .filter(b -> b.getBookId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book updateBook(int id, Book updatedBook) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setAvailable(updatedBook.isAvailable());
                book.setBookCategory(updatedBook.getBookCategory());
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getBooksByCategoryName(String categoryName) {
        return books.stream()
                .filter(b -> b.getBookCategory() != null &&
                        b.getBookCategory().getCategoryName().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
