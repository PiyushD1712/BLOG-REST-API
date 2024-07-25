package com.example.Blog_Website.controller;

import com.example.Blog_Website.model.User;
import com.example.Blog_Website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserService service;

    @GetMapping({"/","/home"})
    public String home(){
        return "Home";
    }

    @PostMapping("/register")
    public void register(@RequestBody User user){
        service.save(user);
    }
    @GetMapping("/users")
    public List<User> login(){
        return service.findAll();
    }
}
