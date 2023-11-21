package com.server.trackingyoutube.services.impl;

import com.server.trackingyoutube.entity.User;
import com.server.trackingyoutube.entity.UserVideo;
import com.server.trackingyoutube.entity.UserVideoID;
import com.server.trackingyoutube.repositories.UserRepository;
import com.server.trackingyoutube.repositories.UserVideoRepository;
import com.server.trackingyoutube.services.UserVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserVideoServiceImpl implements UserVideoService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserVideoRepository userVideoRepository;


    @Override
    public List<Object> getAllVideoByIDUSer(String id) {
        return userVideoRepository.listVideoByIDUser(id);
    }

    @Override
    public UserVideo saveOrUpdateUserVideo(UserVideo userVideo) {
        return userVideoRepository.save(userVideo);
    }

    @Override
    public UserVideo findUserVideoByID(UserVideoID userVideoID) {
        return userVideoRepository.findUserVideoById(userVideoID);
    }

}
