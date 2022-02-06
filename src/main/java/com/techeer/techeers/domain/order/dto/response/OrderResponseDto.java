package com.techeer.techeers.domain.order.dto.response;

import com.techeer.techeers.domain.product.dto.response.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Long id;
    private Long userId;
    private List<ProductResponseDto> products;
}
