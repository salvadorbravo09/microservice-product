package com.microservice.product.services.impl;

import com.microservice.product.exceptions.CategoryNotFoundException;
import com.microservice.product.exceptions.ProductNotFoundException;
import com.microservice.product.mapper.ProductMapper;
import com.microservice.product.models.dtos.CreateProductRequest;
import com.microservice.product.models.dtos.ProductResponse;
import com.microservice.product.models.entities.Product;
import com.microservice.product.repositories.CategoryRepository;
import com.microservice.product.repositories.ProductRepository;
import com.microservice.product.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toProductResponse(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(product -> productMapper.toProductResponse(product))
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found")); // Si no existe, lanzamos la excepcion.
    }

    @Override
    public List<ProductResponse> findAllByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> productRepository.findAllByCategory(category)) // Obtiene una lista de productos
                .map(products -> products.stream() // Convierte la lista a un Stream
                        .map(product -> productMapper.toProductResponse(product)) // Mapea cada producto a ProductResponse
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found"));
    }

    @Override
    public ProductResponse save(CreateProductRequest createProductRequest) {
        return categoryRepository.findById(createProductRequest.getCategoryId())
                .map(category -> {
                    Product product = new Product();
                    product.setName(createProductRequest.getName());
                    product.setDescription(createProductRequest.getDescription());
                    product.setPrice(createProductRequest.getPrice());
                    product.setCategory(category);
                    product.setStatus(Boolean.TRUE);
                    return productRepository.save(product);
                })
                .map(product -> productMapper.toProductResponse(product))
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + createProductRequest.getCategoryId() + " not found"));
    }

    @Override
    public ProductResponse update(Long id, CreateProductRequest createProductRequest) {
        return productRepository.findById(id)
                .map(product -> categoryRepository.findById(createProductRequest.getCategoryId())
                        .map(category -> {
                            product.setName(createProductRequest.getName());
                            product.setDescription(createProductRequest.getDescription());
                            product.setPrice(createProductRequest.getPrice());
                            product.setCategory(category);
                            return productRepository.save(product);
                        })
                        .orElseThrow(() -> new CategoryNotFoundException("Category with id " + createProductRequest.getCategoryId() + " not found")))
                .map(product -> productMapper.toProductResponse(product))
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + createProductRequest.getCategoryId() + " not found"));
    }

    @Override
    public void deleteById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}
