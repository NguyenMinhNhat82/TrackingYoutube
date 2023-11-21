package com.server.trackingyoutube.repositories;


import com.server.trackingyoutube.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,String> {
    Video findFirstById(String id);
}
