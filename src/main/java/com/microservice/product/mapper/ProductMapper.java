package com.microservice.product.mapper;

import com.microservice.product.models.dtos.ProductResponse;
import com.microservice.product.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.microservice.product.utils.Constants.ACTIVE_STATUS;
import static com.microservice.product.utils.Constants.INACTIVE_STATUS;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mapping(target = "status", expression = "java(mapStatus(product))")
    ProductResponse toProductResponse(Product product);

    // Metodo encargado de Mapear el status del campo Product al ProductResponse
    default String mapStatus(Product product) {
        return product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }
}
