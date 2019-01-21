package com.example.postgresdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * User: ankoks
 * Date: 21/01/2019
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/hello")
    public String main() {
        return "hello";
    }
}
