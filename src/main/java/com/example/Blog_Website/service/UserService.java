package com.example.Blog_Website.service;

import com.example.Blog_Website.model.User;
import com.example.Blog_Website.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(12);

    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
    public List<User> findAll(){
        return userRepo.findAll();
    }
    public User getUser(String email){
        return userRepo.findUserByEmail(email);
    }
    public User findUser(Long id) {
        if(userRepo.findById(id).isEmpty()) {
            return new User();
        }
        return userRepo.findById(id).get();
    }
}
