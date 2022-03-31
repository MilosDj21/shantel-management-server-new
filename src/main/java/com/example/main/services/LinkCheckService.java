package com.example.main.services;

import com.example.main.models.LinkCheckModel;
import com.example.main.repositories.LinkCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkCheckService {
    @Autowired
    private LinkCheckRepository linkCheckRepository;


    public List<LinkCheckModel> findAll(){
        return linkCheckRepository.findAll();
    }

    public LinkCheckModel findById(long id){
        return linkCheckRepository.findById(id).orElse(null);
    }

    public List<LinkCheckModel> findAllByClientId(long clientId){
        return linkCheckRepository.findAllByKlijentId(clientId);
    }

    public List<LinkCheckModel> findAllByUserId(long userId){
        return linkCheckRepository.findAllByKorisnikId(userId);
    }

    public LinkCheckModel saveOne(LinkCheckModel link){
        return linkCheckRepository.save(link);
    }

    public void deleteById(long id){
        linkCheckRepository.deleteById(id);
    }
}
