package com.techeer.techeers.domain.order.entity;

import com.techeer.techeers.domain.product.entity.Product;
import com.techeer.techeers.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Order\"")
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<Product> products = new HashSet<>();

    @CreatedDate
    private LocalDateTime orderDate;

    @Builder
    public Order(User user) {
        this.user = user;
    }

    public void update(User user) {
        this.user = user;
    }

    public void addProduct(Product product) {
        product.setOrder(this);
        products.add(product);
    }
}
