package com.ijse.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.database.entity.Product;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> findByCategory(Long id);
}
