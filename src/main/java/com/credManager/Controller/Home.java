package com.credManager.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome to us";
    }


    @RequestMapping("/getUsers")
    public String getUser(){
        return "{\"name\":\"Vivek\"}";
    }
}
