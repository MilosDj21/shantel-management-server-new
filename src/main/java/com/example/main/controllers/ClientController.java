package com.example.main.controllers;

import com.example.main.models.ClientModel;
import com.example.main.models.UserModel;
import com.example.main.services.ClientService;
import com.example.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private UserService userService;

    @GetMapping("/clients")
    public List<ClientModel> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/users/{userId}/clients")
    public List<ClientModel> findAllByUserId(@PathVariable long userId){
        return clientService.findAllByUserId(userId);
    }

    @PostMapping("/clients")
    public ClientModel saveOne(@RequestBody ClientModel clientModel){
        return clientService.saveOne(clientModel);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteOne(@PathVariable long id){
        clientService.deleteById(id);
    }
}
