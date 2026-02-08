package com.rath.practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String helloWorld(){
        return "Hello World!";
    }
}
