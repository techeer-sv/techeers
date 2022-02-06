package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.UserCreateDto;
import com.techeer.techeers.domain.user.dto.UserUpdateDto;
import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.repository.UserRepository;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserEntity userEntity;

    @GetMapping("/{email}")
    public UserEntity getUser (@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping
    public String createUser(@RequestBody UserCreateDto userDto) {
        UserEntity user = userService.save(userDto.toEntity());

//        return "Hello" + userDto.getEmail() + userDto.getFirstName() + userDto.getPassword() + userDto.getPhoneNumber();
        return userRepository.findAll().toString();
//        UserCreateDto userCreateDto = modelMapper
    }
}
