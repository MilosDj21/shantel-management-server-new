package com.example.main.services;

import com.example.main.models.ClientModel;
import com.example.main.models.LinkModel;
import com.example.main.models.UserModel;
import com.example.main.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LinkService linkService;

    public List<ClientModel> findAll(){
        return clientRepository.findAll();
    }

    public ClientModel findById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<ClientModel> findAllByUserId(long userId){
        List<LinkModel> list = linkService.findAllByUserId(userId);
        List<ClientModel> clientList = new ArrayList<>();
        for(LinkModel l: list){
            if(!clientList.contains(l.getKlijent())) {
                clientList.add(l.getKlijent());
            }
        }
        return clientList;
    }

    public ClientModel saveOne(ClientModel model){
        return clientRepository.save(model);
    }

    public void deleteById(long id){
        clientRepository.deleteById(id);
    }



}
