package com.techeer.techeers.domain.product.dto.mapper;

import com.techeer.techeers.domain.product.dto.request.ProductCreateRequestDto;
import com.techeer.techeers.domain.product.dto.request.ProductUpdateRequestDto;
import com.techeer.techeers.domain.product.dto.response.ProductResponseDto;
import com.techeer.techeers.domain.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductCreateRequestDto dto) {
        return Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .build();
    }

    public Product toEntity(ProductUpdateRequestDto dto) {
        return Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .build();
    }

    public ProductResponseDto toResponseDto(Product entity) {
        return ProductResponseDto.builder()
                .productName(entity.getProductName())
                .price(entity.getPrice())
                .build();
    }
}
