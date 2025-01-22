package com.microservice.product.models.dtos;

import java.math.BigDecimal;

public class CreateProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
}
