package com.sahu.springboot.basics.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {super(message);}
}
