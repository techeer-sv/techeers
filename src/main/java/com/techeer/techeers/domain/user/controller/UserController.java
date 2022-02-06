package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.mapper.UserMapper;
import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.dto.request.UserUpdateRequestDto;
import com.techeer.techeers.domain.user.dto.response.UserResponseDto;
import com.techeer.techeers.domain.user.entity.User;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController<c> {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<UserResponseDto> crete(@Valid @RequestBody UserCreateRequestDto requestDto) {
        userService.checkEmailDuplication(requestDto);
        User entity = userService.save(userMapper.toEntity(requestDto));
        return ResponseEntity.created(
                    WebMvcLinkBuilder
                        .linkTo(UserController.class)
                        .slash(entity.getId())
                        .toUri()
                )
                .body(userMapper.toResponseDto(entity));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> list() {
        List<UserResponseDto> entityList = userService.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok()
                .body(entityList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        User entity = userService.findById(id);
        return ResponseEntity.ok()
                .body(userMapper.toResponseDto(entity));

    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable String email) {
        User entity = userService.findByEmail(email);
        return ResponseEntity.ok()
                .body(userMapper.toResponseDto(entity));

    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        userService.deleteAllData();
        return ResponseEntity.ok()
                .body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok()
                .body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {

        User updatedEntity = userService.update(id, userMapper.toEntity(requestDto));
        return ResponseEntity.ok()
                .body(userMapper.toResponseDto(updatedEntity));
    }
}
