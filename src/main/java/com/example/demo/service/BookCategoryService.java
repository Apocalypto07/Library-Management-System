package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.BookCategory;

public interface BookCategoryService {

    BookCategory addCategory(BookCategory category);

    List<BookCategory> getAllCategories();

    BookCategory getCategoryById(int id);

    BookCategory updateCategory(int id, BookCategory category);
}
