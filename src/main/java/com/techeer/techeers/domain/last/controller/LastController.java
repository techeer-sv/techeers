package com.techeer.techeers.domain.last.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/last")
public class LastController {
    @GetMapping
    @ResponseBody
    public String requestParam(
         @RequestParam String name, @RequestParam String phoneNum
    ){
        return ("Hello"+ name + phoneNum);
    }
}
