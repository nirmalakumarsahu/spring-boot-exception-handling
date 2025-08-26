package com.sahu.springboot.basics.service.impl;

import com.sahu.springboot.basics.dto.ProductRequest;
import com.sahu.springboot.basics.dto.ProductResponse;
import com.sahu.springboot.basics.exception.ProductAlreadyExistException;
import com.sahu.springboot.basics.exception.ProductNotFoundException;
import com.sahu.springboot.basics.model.Product;
import com.sahu.springboot.basics.repository.ProductRepository;
import com.sahu.springboot.basics.service.ProductService;
import com.sahu.springboot.basics.service.util.ProductUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id).map(ProductUtil::toProductResponse)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    @Override
    public ProductResponse findByName(String name) {
        return productRepository.findByName(name).map(ProductUtil::toProductResponse)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with name " + name));

    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(ProductUtil::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse add(ProductRequest productRequest) {
        if(productRepository.existsByName(productRequest.name())) {
            throw new ProductAlreadyExistException("Product is already exist with name "+productRequest.name());
        }

        Product product = productRepository.save(ProductUtil.toProduct(productRequest));
        return ProductUtil.toProductResponse(product);
    }

}
