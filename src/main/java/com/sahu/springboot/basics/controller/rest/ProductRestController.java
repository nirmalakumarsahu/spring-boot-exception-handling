package com.sahu.springboot.basics.controller.rest;

import com.sahu.springboot.basics.dto.ApiResponse;
import com.sahu.springboot.basics.dto.ProductRequest;
import com.sahu.springboot.basics.dto.ProductResponse;
import com.sahu.springboot.basics.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        return ApiResponse.success(HttpStatus.OK, "Product Found Successfully!",
                productService.getProductById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductByName(@PathVariable String name) {
        return ApiResponse.success(HttpStatus.OK, "Product Found Successfully!",
                productService.getProductByName(name));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {
        return ApiResponse.success(HttpStatus.OK, "Products Found",
                productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest) {
        return ApiResponse.success(HttpStatus.CREATED, "Product Created",
                productService.createProduct(productRequest));
    }

}
