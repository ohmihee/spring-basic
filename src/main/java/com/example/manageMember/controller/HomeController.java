package com.example.manageMember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
