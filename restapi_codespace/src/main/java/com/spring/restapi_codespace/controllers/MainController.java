package com.spring.restapi_codespace.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @GetMapping(path = {"/","/home"})
    public String home()
    {
        return "Home page";
    }

    @GetMapping("/home/services")
    public String services()
    {
        return "services page under home page";
    }
}
