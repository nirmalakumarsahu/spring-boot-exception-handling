package com.sahu.springboot.basics.controller.rest;

import com.sahu.springboot.basics.dto.ApiResponse;
import com.sahu.springboot.basics.dto.ProductRequest;
import com.sahu.springboot.basics.dto.ProductResponse;
import com.sahu.springboot.basics.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<ApiResponse<ProductResponse>> getById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK, "Product Found Successfully!",
                productService.findById(id), httpServletRequest.getRequestURI())
        );
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse<ProductResponse>> getByName(@PathVariable String name, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK, "Product Found Successfully!",
                productService.findByName(name), httpServletRequest.getRequestURI())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> all(HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK, "Products Found",
                productService.findAll(),  httpServletRequest.getRequestURI())
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> add(@RequestBody ProductRequest productRequest, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(HttpStatus.CREATED, "Product Created",
                productService.add(productRequest), httpServletRequest.getRequestURI()));
    }

}
