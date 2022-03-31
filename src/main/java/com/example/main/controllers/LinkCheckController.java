package com.example.main.controllers;

import com.example.main.models.*;
import com.example.main.services.ClientService;
import com.example.main.services.LinkCheckService;
import com.example.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
public class LinkCheckController {
    @Autowired
    private LinkCheckService linkCheckService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private UserService userService;

    @GetMapping("/linkcheck")
    public List<LinkCheckModel> findAll(){
        return linkCheckService.findAll();
    }

    @GetMapping("/clients/{clientId}/linkcheck")
    public List<LinkCheckModel> findAllByClientId(@PathVariable long clientId){
        return linkCheckService.findAllByClientId(clientId);
    }

    @GetMapping("/users/{userId}/linkcheck")
    public List<LinkCheckModel> findAllByUsertId(@PathVariable long userId){
        return linkCheckService.findAllByUserId(userId);
    }

    @PostMapping("/users/{userId}/clients/{clientId}/linkcheck")
    public LinkCheckModel saveOne(@PathVariable long userId, @PathVariable long clientId, @RequestBody LinkCheckModel linkCheckModel){
        ClientModel c = clientService.findById(clientId);
        UserModel u = userService.findById(userId);
        linkCheckModel.setKlijent(c);
        linkCheckModel.setKorisnik(u);
        return linkCheckService.saveOne(linkCheckModel);
    }

    @DeleteMapping("/linkcheck/{id}")
    public void deleteById(@PathVariable long id){
        linkCheckService.deleteById(id);
    }
}
