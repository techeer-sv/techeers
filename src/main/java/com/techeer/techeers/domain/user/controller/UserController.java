package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.mapper.UserMapper;
import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.dto.request.UserUpdateRequestDto;
import com.techeer.techeers.domain.user.dto.response.UserResponseDto;
import com.techeer.techeers.domain.user.entity.User;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getList() {

        List<UserResponseDto> entityList = userService.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .body(entityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> get(@PathVariable Long id) {

        User entity = userService.findById(id);

        return ResponseEntity
                .ok()
                .body(userMapper.toResponseDto(entity));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserCreateRequestDto requestDto) {

        User entity = userService.create(userMapper.toEntity(requestDto));

        return ResponseEntity
                .created(WebMvcLinkBuilder
                        .linkTo(this.getClass())
                        .slash(entity.getId())
                        .toUri()
                )
                .body(userMapper.toResponseDto(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {

        User updatedEntity = userService.update(id, userMapper.toEntity(requestDto));

        return ResponseEntity
                .ok()
                .body(userMapper.toResponseDto(updatedEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);
        return ResponseEntity
                .ok()
                .body(null);
    }
}
