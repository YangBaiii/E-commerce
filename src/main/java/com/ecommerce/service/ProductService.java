package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.payload.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDTO addProduct(Product product, Long categoryId);
}
