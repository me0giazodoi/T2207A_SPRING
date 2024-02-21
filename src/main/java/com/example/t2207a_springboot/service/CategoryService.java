package com.example.t2207a_springboot.service;

import com.example.t2207a_springboot.entities.Category;
import com.example.t2207a_springboot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long id, Category category){
        return categoryRepository.findById(id)
                .map(p-> {
                    p.setName(category.getName());
                    p.setSlug(category.getSlug());
                    p.setStatus(category.getStatus());
                    return categoryRepository.save(p);
                })
                .orElseGet(()->{
                    category.setId(id);
                    return categoryRepository.save(category);
                });
    }
    public void deleteCategory (Long id){
        categoryRepository.deleteById(id);
    }
}
