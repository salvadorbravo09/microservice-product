package com.microservice.product.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateProductRequest {

    @NotEmpty(message = "The field name cannot be empty or null")
    private String name;

    private String description;

    @NotNull(message = "The field price cannot be null")
    private BigDecimal price;

    @NotNull(message = "The field category_id cannot be null")
    private Long categoryId;
}
