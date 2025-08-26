package com.sahu.springboot.basics.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        String description
)
{
}
