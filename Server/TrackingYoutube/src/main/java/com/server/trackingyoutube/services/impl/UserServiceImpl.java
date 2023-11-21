package com.server.trackingyoutube.services.impl;


import com.server.trackingyoutube.entity.User;
import com.server.trackingyoutube.repositories.UserRepository;
import com.server.trackingyoutube.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUserByID(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User saveUser(User user) {
         return  userRepository.save(user);
    }
}
