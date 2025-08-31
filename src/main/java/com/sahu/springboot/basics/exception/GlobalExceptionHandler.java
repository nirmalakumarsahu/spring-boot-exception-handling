package com.sahu.springboot.basics.exception;

import com.sahu.springboot.basics.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
    {
        return buildErrorResponse(HttpStatus.NOT_FOUND, productNotFoundException.getMessage());
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ApiResponse<String>> handleProductAlreadyExistException(ProductAlreadyExistException productAlreadyExistException)
    {
        return buildErrorResponse(HttpStatus.CONFLICT, productAlreadyExistException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception exception) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    private ResponseEntity<ApiResponse<String>> buildErrorResponse(HttpStatus httpStatus, String message) {
        ApiResponse<String> response = ApiResponse.error(
                httpStatus,
                message,
                null
        );

        return ResponseEntity.status(httpStatus).body(response);
    }

}
