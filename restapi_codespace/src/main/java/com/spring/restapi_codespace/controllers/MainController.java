package com.spring.restapi_codespace.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    private static List<String> users=new ArrayList<>();
    
    static{
        users.add("user1");
        users.add("user2");
        users.add("user3");
        users.add("user4");
    }


    @GetMapping(path = {"/","/home"})
    public String home()
    {
        return "Home page";
    }

    @GetMapping("/home/services")
    public String services(){
        return "services page under home page";
    }

    @GetMapping("/home/user/{id}")
    public String getUserController(@PathVariable int id)
    {
        return getUser(id);
    }

    public String getUser(int id){
        return users.get(id-1);
    }
}
