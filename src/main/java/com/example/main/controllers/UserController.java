package com.example.main.controllers;

import com.example.main.models.UserModel;
import com.example.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserModel> findAll(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public UserModel saveOne(@RequestBody UserModel user){
        return userService.saveOne(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable long id){
        userService.deleteById(id);
    }
}
