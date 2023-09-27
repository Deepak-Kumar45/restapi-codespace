package com.spring.restapi_codespace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @RequestMapping(path = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "Home page using traditional @Controller annotation and @RequestMapping annotation";
    }
}
