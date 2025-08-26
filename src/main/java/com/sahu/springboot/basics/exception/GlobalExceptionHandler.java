package com.sahu.springboot.basics.exception;

import com.sahu.springboot.basics.dto.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleProductNotFoundException(ProductNotFoundException productNotFoundException,
                                                                              HttpServletRequest httpServletRequest)
    {
        return buildErrorResponse(HttpStatus.NOT_FOUND, productNotFoundException.getMessage(), httpServletRequest);
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ApiResponse<String>> handleProductAlreadyExistException(ProductAlreadyExistException productAlreadyExistException,
                                                                                  HttpServletRequest httpServletRequest)
    {
        return buildErrorResponse(HttpStatus.CONFLICT, productAlreadyExistException.getMessage(), httpServletRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception exception, HttpServletRequest httpServletRequest) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), httpServletRequest);
    }

    private ResponseEntity<ApiResponse<String>> buildErrorResponse(HttpStatus httpStatus, String message, HttpServletRequest httpServletRequest) {
        ApiResponse<String> response = ApiResponse.error(
                httpStatus,
                message,
                null,
                httpServletRequest.getRequestURI()
        );

        return ResponseEntity.status(httpStatus).body(response);
    }

}
