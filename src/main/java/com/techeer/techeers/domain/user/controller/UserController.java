package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.request.UserCreateRequestDto;
import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.repository.UserRepository;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserEntity crete(@RequestBody UserCreateRequestDto userDto) {
        UserEntity userEntityCreated = userService.save(userDto.toEntity());
        return userEntityCreated;
    }

    @GetMapping("/users")
    public List<UserEntity> list() {
        List<UserEntity> userEntities = userService.findUsers();
        return userEntities;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") long id, @RequestBody UserCreateRequestDto userDto) {
        Optional<UserEntity> userEntity = userService.findById(id);
        if (userEntity.isPresent()) {
            return new ResponseEntity<>(userEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users")
    public void delete() {
        userService.deleteAllData();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable("id") long id, @RequestBody UserCreateRequestDto userdto) {
        Optional<UserEntity> userData = userService.findById(id);
        if (userData.isPresent()) {
            UserEntity _userEntity = userData.get();
            _userEntity.setEmail(userdto.getEmail());
            _userEntity.setFirstName(userdto.getFirstName());
            return new ResponseEntity<>(userService.save(_userEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
