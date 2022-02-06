package com.techeer.techeers.domain.order.service;

import com.techeer.techeers.domain.order.entity.Order;
import com.techeer.techeers.domain.order.repository.OrderRepository;
import com.techeer.techeers.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order create(Order entity) {
        return orderRepository.save(entity);
    }

    @Transactional
    public Order update(Long id, Order updatedEntity) {

        Order entity = this.findById(id);
        entity.update(entity.getUser());
        updatedEntity.getProducts()
                .stream()
                .forEach((product) -> entity.addProduct(product));
        return orderRepository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id=" + id));
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
