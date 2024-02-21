package com.example.t2207a_springboot.controller;

import com.example.t2207a_springboot.entities.Category;
import com.example.t2207a_springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping()
    public List<Category> getAllCategory(){
        return categoryService.getAll();
    }
    @PostMapping()
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
