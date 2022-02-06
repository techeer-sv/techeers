package com.techeer.techeers.domain.product.entity;

import com.techeer.techeers.domain.order.entity.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String productName;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @Setter
    private Order order;

    @Builder
    public Product(BigDecimal price, String productName, Order order) {
        this.price = price;
        this.productName = productName;
        this.order = order;
    }

    public void update(BigDecimal price, String productName, Order order) {
        this.price = price;
        this.productName = productName;
        this.order = order;
    }
}
