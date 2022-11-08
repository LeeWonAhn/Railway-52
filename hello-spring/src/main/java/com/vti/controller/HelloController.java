package com.vti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController = Response + controller
// @RestController: Đánh dấu class này là controller
@RestController
// @RequestMapping: Đặt đường dẫn URL chung cho cả controller này
@RequestMapping("/api/v1/hello")
public class HelloController {
    @GetMapping
    public String hello(@RequestParam(value =  "name", defaultValue = "Spring") String name) {
        return "Hello, " + name;
    }
}
