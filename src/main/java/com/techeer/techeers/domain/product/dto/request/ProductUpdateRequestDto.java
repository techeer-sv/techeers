package com.techeer.techeers.domain.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDto {

    @NotNull
    @Size(max = 50)
    private String productName;

    @NotNull
    @Min(0)
    private BigDecimal price;
}
