package org.example.spring.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/print")

public class HelloController {

    private final HelloService helloService;
    @GetMapping("/hello")
    public String printHello() {
        return helloService.printHello();
    }
}
