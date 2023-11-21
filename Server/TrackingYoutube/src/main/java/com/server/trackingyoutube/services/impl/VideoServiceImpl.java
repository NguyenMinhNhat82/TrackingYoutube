package com.server.trackingyoutube.services.impl;


import com.server.trackingyoutube.entity.Video;
import com.server.trackingyoutube.repositories.VideoRepository;
import com.server.trackingyoutube.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video findVideoByID(String id) {
        return videoRepository.findFirstById(id);
    }

    @Override
    public Video saveOrUpDateVideo(Video video) {
        return videoRepository.save(video);
    }

}
