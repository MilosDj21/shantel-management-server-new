package com.example.main.services;

import com.example.main.models.MessageModel;
import com.example.main.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> findAll(){
        return messageRepository.findAll();
    }

    public MessageModel findById(long id){
        return messageRepository.findById(id).orElse(null);
    }

    public List<MessageModel> findAllByLinkCheckId(long linkCheckId){
        return messageRepository.findAllByLinkZaProveruId(linkCheckId);
    }

    public MessageModel saveOne(MessageModel message){
        return messageRepository.save(message);
    }

    public void deleteById(long id){
        messageRepository.deleteById(id);
    }

}
