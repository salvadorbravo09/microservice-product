package com.microservice.product.services;

import com.microservice.product.models.dtos.CreateProductRequest;
import com.microservice.product.models.dtos.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    List<ProductResponse> findAllByCategoryId(Long categoryId);

    ProductResponse save(CreateProductRequest createProductRequest);

    ProductResponse update(Long id, CreateProductRequest createProductRequest);

    void deleteById(Long id);
}
