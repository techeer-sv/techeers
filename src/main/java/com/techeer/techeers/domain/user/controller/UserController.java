package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.Request;
import com.techeer.techeers.domain.user.dto.Response;
import com.techeer.techeers.domain.user.entity.UserEntity;
import com.techeer.techeers.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // 컨트롤러에 필수
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Response> create(@RequestBody Request reqDTO) {
//        firstName = req.getFirst_name();
//        lastName = req.getLast_name();
//        email = req.getEmail();
//        password= req.getPassword();
//        phoneNumber = req.getPhone_number();
//        addressId = req.getAddress_id();

        UserEntity entity = userService.create(
                UserEntity.builder() // java builder pattern
                        .firstName(reqDTO.getFirstName())
                        .lastName(reqDTO.getLastName())
                        .email(reqDTO.getEmail())
                        .password(reqDTO.getPassword())
                        .phoneNumber(reqDTO.getPhoneNumber())
                        .addressId(reqDTO.getAddressId())
                        .build()
        );

        Response responseDTO = Response.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();

        return ResponseEntity.created(
                WebMvcLinkBuilder  // HATEOAS
                        .linkTo(UserController.class)
                        .slash(entity.getUserId())
                        .toUri()
        )
                .body(responseDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable Long id) {
        UserEntity entity = userService.findById(id);
        Response responseDTO = Response.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
        return ResponseEntity
                .ok()
                .body(responseDTO);
    }
}
