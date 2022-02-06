package com.techeer.techeers.domain.order.controller;

import com.techeer.techeers.domain.order.dto.mapper.OrderMapper;
import com.techeer.techeers.domain.order.dto.request.OrderCreateRequestDto;
import com.techeer.techeers.domain.order.dto.request.OrderUpdateRequestDto;
import com.techeer.techeers.domain.order.dto.response.OrderResponseDto;
import com.techeer.techeers.domain.order.entity.Order;
import com.techeer.techeers.domain.order.service.OrderService;
import com.techeer.techeers.domain.user.entity.User;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getList() {

        List<Order> entityList = orderService.findAll();

        return ResponseEntity
                .ok()
                .body(entityList
                        .stream()
                        .map(orderMapper::toResponseDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> get(@PathVariable Long id) {

        Order entity = orderService.findById(id);

        return ResponseEntity
                .ok()
                .body(orderMapper.toResponseDto(entity));
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(@Valid @RequestBody OrderCreateRequestDto requestDto) {

        User user = userService.findById(requestDto.getUserId());
        Order entity = orderMapper.toEntity(requestDto);
        entity.setUser(user);
        entity = orderService.create(entity);

        return ResponseEntity
                .created(WebMvcLinkBuilder
                        .linkTo(this.getClass())
                        .slash(entity.getId())
                        .toUri())
                .body(orderMapper.toResponseDto(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> update(@PathVariable Long id, @Valid @RequestBody OrderUpdateRequestDto requestDto) {

        User user = userService.findById(requestDto.getUserId());
        Order entity = orderMapper.toEntity(requestDto);
        entity.setUser(user);
        Order updatedEntity = orderService.create(entity);

        return ResponseEntity
                .ok()
                .body(orderMapper.toResponseDto(updatedEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        orderService.delete(id);
        return ResponseEntity
                .ok()
                .body(null);
    }
}
