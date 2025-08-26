package com.sahu.springboot.basics.dto;

import java.math.BigDecimal;

public record ProductRequest(
        String name,
        BigDecimal price,
        String description
)
{
}
