package org.example.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring.service.HelloService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class HelloServiceImpl implements HelloService {
    @Override
    public String printHello() {
        return "Hello";
    }
}
