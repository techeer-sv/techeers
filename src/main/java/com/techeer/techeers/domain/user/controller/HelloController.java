package com.techeer.techeers.domain.user.controller;

import com.techeer.techeers.domain.user.dto.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {
    @GetMapping("/querystringtest")
    public String getHello(@RequestParam String number) {

//            entity = To_entity
//            userService.creatuser(number) // service function
        return "hello" + " " + number;
    }

    @PostMapping("/user")
    public String getHello(@RequestBody Example cont) {

        return "hello" + " " + cont.getName();
    }


//    @PostMapping // POST /api/v1/users
//    public UserReesponseDto getHello(@RequestBody UserCreateRequestDto requestDto) {
//
//            // business logic... (service)
//        // user = ...
//        return new UserReesponseDto(user.getName());
//    }
}
