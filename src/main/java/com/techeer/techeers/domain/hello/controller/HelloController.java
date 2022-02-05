package com.techeer.techeers.domain.hello.controller;

import com.techeer.techeers.domain.hello.dto.request.HelloRequestDto;
import com.techeer.techeers.domain.hello.dto.response.HelloResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<HelloResponseDto> getHelloQuery(@RequestParam String name) {

        HelloResponseDto response = HelloResponseDto.builder()
                .result("Hello " + name)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<HelloResponseDto> getHelloPath(@PathVariable String name) {

        HelloResponseDto response = HelloResponseDto.builder()
                .result("Hello " + name)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping
    public ResponseEntity<HelloResponseDto> getHelloBody(@RequestBody HelloRequestDto helloDto) {

        HelloResponseDto response = HelloResponseDto.builder()
                .result(helloDto.getName())
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
