package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.BookCategory;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    private Map<Long, BookCategory> store = new HashMap<>();
    private long idCounter = 1;

    @Override
    public BookCategory addCategory(BookCategory category) {
        category.setCategoryId(idCounter); 
        store.put(idCounter, category);
        idCounter++;
        return category;
    }

    @Override
    public List<BookCategory> getAllCategories() {
        return new ArrayList<>(store.values());
    }

    @Override
    public BookCategory getCategoryById(int id) {
        return store.get((long) id); 
    }

    @Override
    public BookCategory updateCategory(int id, BookCategory category) {
        BookCategory existing = store.get((long) id);
        if (existing != null) {
            existing.setCategoryName(category.getCategoryName());
        }
        return existing;
    }
}
