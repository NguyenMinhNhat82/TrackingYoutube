package com.server.trackingyoutube.services;

import com.server.trackingyoutube.entity.User;
import com.server.trackingyoutube.entity.UserVideo;
import com.server.trackingyoutube.entity.UserVideoID;
import com.server.trackingyoutube.entity.Video;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.LongStream;


public interface UserVideoService {

    List<Object> getAllVideoByIDUSer(String id);

    UserVideo saveOrUpdateUserVideo(UserVideo userVideo);
    UserVideo findUserVideoByID(UserVideoID userVideoID);
}
