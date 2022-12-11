package com.example.basic.controller;

import com.example.basic.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
public class HelloController {

    @GetMapping("")
    //@ResponseBody
    public User helloString(@RequestParam("name")String name)  {
        User user = new User();
        user.setUserName(name);
        return user;
    }



}
