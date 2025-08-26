package com.sahu.springboot.basics.dto;

import java.math.BigDecimal;

public record ProductRequest(
        String name,
        String description,
        BigDecimal price,
        Integer quantity
)
{
}
