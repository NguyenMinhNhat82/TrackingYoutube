package com.server.trackingyoutube.services;

import com.server.trackingyoutube.entity.Video;

public interface VideoService {
    public Video findVideoByID(String id);
    Video saveOrUpDateVideo(Video video);
}
