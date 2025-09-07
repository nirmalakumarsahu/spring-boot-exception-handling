package com.sahu.springboot.basics.service;

import com.sahu.springboot.basics.dto.ProductRequest;
import com.sahu.springboot.basics.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse  getProductById(Long id);

    ProductResponse getProductByName(String name);

    List<ProductResponse> getAllProducts();

    ProductResponse createProduct(ProductRequest productRequest);
}
