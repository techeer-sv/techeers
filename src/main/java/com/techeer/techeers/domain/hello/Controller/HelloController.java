package com.techeer.techeers.domain.hello.Controller;

import com.techeer.techeers.dto.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/querystringtest")
    public String getHello(@RequestParam String number) {

        return "hello" + " " + number;
    }



    @PostMapping("/jsonexample")
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
