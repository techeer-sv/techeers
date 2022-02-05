package com.techeer.techeers.domain.user.controller;

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

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> get() {

        List<UserResponseDto> entityList = userService.findAll().stream().map((entity) -> UserResponseDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .build()).collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(entityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> get(@PathVariable Long id) {

        User entity = userService.findOneById(id);

        UserResponseDto responseDto = UserResponseDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .build();

        return ResponseEntity.ok()
                .body(responseDto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserCreateRequestDto requestDto) {

        User entity = userService.create(
                User.builder()
                        .email(requestDto.getEmail())
                        .password(requestDto.getPassword())
                        .build()
        );

        UserResponseDto responseDto = UserResponseDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .build();

        return ResponseEntity.created(
                        WebMvcLinkBuilder
                                .linkTo(UserController.class)
                                .slash(entity.getId())
                                .toUri()
                )
                .body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {

        User updatedEntity = userService.update(
                id,
                User.builder()
                        .email(requestDto.getEmail())
                        .password(requestDto.getPassword())
                        .build()
        );

        UserResponseDto responseDto = UserResponseDto.builder()
                .id(updatedEntity.getId())
                .email(updatedEntity.getEmail())
                .build();

        return ResponseEntity.ok()
                .body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok()
                .body(null);
    }
}