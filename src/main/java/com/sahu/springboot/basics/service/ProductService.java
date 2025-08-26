package com.sahu.springboot.basics.service;

import com.sahu.springboot.basics.dto.ProductRequest;
import com.sahu.springboot.basics.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse  findById(Long id);

    ProductResponse findByName(String name);

    List<ProductResponse> findAll();

    ProductResponse add(ProductRequest productRequest);
}
