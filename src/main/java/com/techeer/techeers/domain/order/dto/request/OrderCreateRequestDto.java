package com.techeer.techeers.domain.order.dto.request;

import com.techeer.techeers.domain.product.dto.request.ProductCreateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private List<ProductCreateRequestDto> products;
}
