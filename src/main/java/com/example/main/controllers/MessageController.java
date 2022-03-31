package com.example.main.controllers;

import com.example.main.models.LinkCheckModel;
import com.example.main.models.MessageModel;
import com.example.main.services.LinkCheckService;
import com.example.main.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private LinkCheckService linkCheckService;

    @GetMapping("/messages")
    public List<MessageModel> findAll(){
        return messageService.findAll();
    }

    @GetMapping("/linkcheck/{linkCheckId}/messages")
    public List<MessageModel> findAllByLinkCheckId(@PathVariable long linkCheckId){
        return messageService.findAllByLinkCheckId(linkCheckId);
    }

    @PostMapping("/linkcheck/{linkCheckId}/messages")
    public MessageModel saveOne(@PathVariable long linkCheckId, @RequestBody MessageModel messageModel){
        LinkCheckModel linkCheckModel = linkCheckService.findById(linkCheckId);
        if(linkCheckModel != null){
            messageModel.setLinkZaProveru(linkCheckModel);
            return messageService.saveOne(messageModel);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/messages/{id}")
    public void deleteById(@PathVariable long id){
        messageService.deleteById(id);
    }
}
