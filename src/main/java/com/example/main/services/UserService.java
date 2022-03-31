package com.example.main.services;

import com.example.main.models.UserModel;
import com.example.main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserModel saveOne(UserModel user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public UserModel findOne(UserModel user){
        List<UserModel> users = findAll();
        if(user.getId() != null && users.contains(user)){
            return user;
        }else{
            for(UserModel u: users){
                if(u.getUsername().equals(user.getUsername()) && new BCryptPasswordEncoder().matches(user.getPassword(), u.getPassword())){
                    return u;
                }
            }
        }
        return null;
    }
}
