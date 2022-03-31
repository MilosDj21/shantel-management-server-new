package com.example.main.controllers;

import com.example.main.models.UserModel;
import com.example.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserModel findOneUser(@RequestBody UserModel user){
        return userService.findOne(user);
    }
}
