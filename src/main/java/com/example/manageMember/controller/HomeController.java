package com.example.manageMember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller("/home")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home.html";
    }
}
