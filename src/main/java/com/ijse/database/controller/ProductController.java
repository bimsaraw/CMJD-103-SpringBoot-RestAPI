package com.ijse.database.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.database.dto.ProductDTO;
import com.ijse.database.entity.Product;
import com.ijse.database.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(201).body(productService.createProduct(productDTO));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if(product != null) {
            return ResponseEntity.status(200).body(product);
            //return product with 200 OK code
        } else {
            return ResponseEntity.status(404).body(null);
            //return 404 Error
        }
    }

    @GetMapping("/categories/{id}/products")
    public List<Product> findByCategory(@PathVariable Long id) {
        return productService.findByCategory(id);
    }
}
