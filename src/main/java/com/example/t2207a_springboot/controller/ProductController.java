package com.example.t2207a_springboot.controller;

import com.example.t2207a_springboot.entities.Product;
import com.example.t2207a_springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping()
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productRepository.findById(id)
                .map(p-> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    p.setQty(product.getQty());
                    p.setThumbnail(product.getThumbnail());
                    p.setDescription(product.getDescription());
                    return productRepository.save(p);
                })
                .orElseGet(()->{
                    product.setId(id);
                    return productRepository.save(product);
                });
    }
}
