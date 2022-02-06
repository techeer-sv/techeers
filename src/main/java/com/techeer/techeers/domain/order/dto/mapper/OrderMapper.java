package com.techeer.techeers.domain.order.dto.mapper;

import com.techeer.techeers.domain.order.dto.request.OrderCreateRequestDto;
import com.techeer.techeers.domain.order.dto.request.OrderUpdateRequestDto;
import com.techeer.techeers.domain.order.dto.response.OrderResponseDto;
import com.techeer.techeers.domain.order.entity.Order;
import com.techeer.techeers.domain.product.dto.mapper.ProductMapper;
import com.techeer.techeers.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductMapper productMapper;

    public Order toEntity(OrderCreateRequestDto dto) {
        Order entity = Order.builder()
                .build();

        dto.getProducts().forEach((productDto) -> {
            entity.addProduct(productMapper.toEntity(productDto));
        });

        return entity;
    }

    public Order toEntity(OrderUpdateRequestDto dto) {
        Order entity = Order.builder()
                .build();

        for (Iterator<Product> it = entity.getProducts().iterator(); it.hasNext(); ) {
            it.next();
            it.remove();
        }

        dto.getProducts().forEach((productDto) -> {
            entity.addProduct(productMapper.toEntity(productDto));
        });

        return entity;
    }

    public OrderResponseDto toResponseDto(Order entity) {
        return OrderResponseDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .products(entity.getProducts()
                        .stream()
                        .map(productMapper::toResponseDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
