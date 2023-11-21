package com.server.trackingyoutube.repositories;


import com.server.trackingyoutube.entity.User;
import com.server.trackingyoutube.entity.UserVideo;
import com.server.trackingyoutube.entity.UserVideoID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserVideoRepository extends JpaRepository<UserVideo,UserVideoID> {


    UserVideo findUserVideoById(UserVideoID id);
    @Query(nativeQuery = true,value = "SELECT a.current_min,a.total_min,a.video_id, b.name FROM" +
            " trackingvideo.user_video a join video b on b.id = a.video_id" +
            " where a.user_id = :id ;")
    List<Object> listVideoByIDUser(@Param("id") String idUser);
}
