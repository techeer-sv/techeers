package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.UserCreateDto;
import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String createUser(@RequestBody UserCreateDto userDto) {
        UserEntity user = userService.save(userDto.toEntity());

        return "Hello" + userDto.getEmail() + userDto.getFirstName() + userDto.getPassword() + userDto.getPhoneNumber();
//        UserCreateDto userCreateDto = modelMapper
    }
}
