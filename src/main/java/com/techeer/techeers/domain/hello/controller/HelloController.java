package com.techeer.techeers.domain.hello.controller;

import com.techeer.techeers.domain.hello.dto.NameDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class HelloController {

    @GetMapping("/plainhello")
    public String plainhello() {
        return "hello !!";
    }
    @GetMapping("/customhello/{name}")
    public String customhello(@PathVariable String name) {
        return "hello " + name + " 바보 !!";
    }

    @GetMapping("/customhello2") //query로 넘겨줘야 함
    public String customHello2(@RequestParam(defaultValue="맹수") String name) {
        return "hello " + name + "!!!";
    }

    @PostMapping(value = "/posts")
    public NameDto posts(@RequestBody NameDto nameDto) {
        return nameDto;
    }
}
