package com.spring.restapi_codespace.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeRestController {

    private static List<String> list=new ArrayList<>();

    static{
        list.add("User-A");
        list.add("User-B");
        list.add("User-C");
        list.add("User-D");
        list.add("User-E");
    }

    @GetMapping(path = "/")
    public String home(){
        return "Home page using rest controller and GetMapping method";
    }

    @GetMapping(path = "/users")
    public List<String> getAllUsers()
    {
        return list;
    }

    @GetMapping("/users/{id}")
    public String getSingleUser(@PathVariable int id){
        return list.get(id-1);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody String user){
        list.add(user);
        return "User has been added sucessfully at "+list.indexOf(user)+" index.";
    }
    
}
