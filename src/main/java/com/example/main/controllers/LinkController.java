package com.example.main.controllers;

import com.example.main.models.ClientModel;
import com.example.main.models.LinkModel;
import com.example.main.models.UserModel;
import com.example.main.services.ClientService;
import com.example.main.services.LinkService;
import com.example.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private UserService userService;

    @GetMapping("/links")
    public List<LinkModel> findAll(){
        return linkService.findAll();
    }

    @GetMapping("/clients/{clientId}/links")
    public List<LinkModel> findAllByClientId(@PathVariable long clientId){
        return linkService.findAllByClientId(clientId);
    }

    @GetMapping("/users/{userId}/links")
    public List<LinkModel> findAllByUsertId(@PathVariable long userId){
        return linkService.findAllByUserId(userId);
    }

    @PostMapping("/users/{userId}/clients/{clientId}/links")
    public LinkModel saveOne(@PathVariable long userId, @PathVariable long clientId, @RequestBody LinkModel linkModel){
        ClientModel c = clientService.findById(clientId);
        UserModel u = userService.findById(userId);
        if(c == null || u == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            linkModel.setKlijent(c);
            linkModel.setKorisnik(u);
            return linkService.saveOne(linkModel);
        }
    }

    @DeleteMapping("/links/{id}")
    public void deleteOne(@PathVariable long id){
        linkService.deleteById(id);
    }
}
