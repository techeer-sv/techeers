package com.techeer.techeers.domain.hello.controller;

import com.techeer.techeers.domain.hello.controller.dto.HelloDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {
    @PostMapping
    public String getHello(@RequestBody HelloDto helloDto) {
        return "Hello"+helloDto.getName();
    }
}
