package com.microservice.product.mapper;

import com.microservice.product.models.dtos.CategoryResponse;
import com.microservice.product.models.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);
}
