package com.server.trackingyoutube.services;


import com.server.trackingyoutube.entity.User;

public interface UserService {

    User findUserByID(String id);
    User saveUser(User user);
}
