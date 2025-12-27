package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService service;

 
    @PostMapping
    public ResponseEntity<BookCategory> createCategory(@RequestBody(required = false) BookCategory category) {
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BookCategory saved = service.addCategory(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<BookCategory> list = service.getAllCategories();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        BookCategory category = service.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>("Book category not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id,
                                            @RequestBody BookCategory category) {
        BookCategory updated = service.updateCategory(id, category);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page/{page}/{size}")
    public Page<BookCategory> getCategoriesWithPagination(
    @PathVariable int page,
    @PathVariable int size) {

    Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
    List<BookCategory> list = service.getAllCategories();
    return new PageImpl<>(list, pageable, list.size());
 }
}    

    
