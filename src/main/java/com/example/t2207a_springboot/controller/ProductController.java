package com.example.t2207a_springboot.controller;

import com.example.t2207a_springboot.entities.Product;
import com.example.t2207a_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAll();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/filterByName")
    public ResponseEntity<List<Product>> filterProductsByName(@RequestParam String name) {
        List<Product> filteredProducts = productService.getProductsByName(name);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }
}
