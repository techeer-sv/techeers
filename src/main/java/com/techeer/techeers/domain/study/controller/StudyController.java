package com.techeer.techeers.domain.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/study")
public class StudyController {
    @GetMapping
    public String Study(){

        return ("test");
    }
}
