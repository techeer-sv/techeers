package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.mapper.UserMapper;
import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.dto.request.UserUpdateRequestDto;
import com.techeer.techeers.domain.user.dto.response.UserResponseDto;
import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.repository.UserRepository;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    //201
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<UserResponseDto> crete(@Valid @RequestBody UserCreateRequestDto requestDto) {
        UserEntity entity = userService.save(userMapper.toEntity(requestDto));
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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserEntity entity = userService.findById(id);
        return ResponseEntity.ok()
                .body(userMapper.toResponseDto(entity));

    }

    @DeleteMapping
    public void delete() {
        userService.deleteAllData();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        try {
//            userService.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        userService.deleteById(id);
        return ResponseEntity.ok()
                .body(null);
    }


    //200
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {

        UserEntity updatedEntity = userService.update(id, userMapper.toEntity(requestDto));
        return ResponseEntity.ok()
                .body(userMapper.toResponseDto(updatedEntity));
    }
}
