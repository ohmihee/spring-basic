package com.example.manageMember.controller;

import com.example.manageMember.service.ComponentScanTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentScanTestController {
    private final ComponentScanTestService componentScanTestService;

    @Autowired
    public ComponentScanTestController (ComponentScanTestService componentScanTestService) {
        this.componentScanTestService = componentScanTestService;
    }
}
