package com.server.trackingyoutube.controller;


import com.server.trackingyoutube.entity.User;
import com.server.trackingyoutube.entity.UserVideo;
import com.server.trackingyoutube.entity.UserVideoID;
import com.server.trackingyoutube.entity.Video;
import com.server.trackingyoutube.services.UserService;
import com.server.trackingyoutube.services.UserVideoService;
import com.server.trackingyoutube.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserVideoController {

    @Autowired
    private UserVideoService videoService;
    @Autowired
    private VideoService vSevice;
    @Autowired
    private UserService userService;

    @GetMapping("/api/video")
    public ResponseEntity<List<Object>> getVideoByUser(@RequestParam("id") String idUser){
        return new ResponseEntity<>(videoService.getAllVideoByIDUSer(idUser), HttpStatus.OK);
    }
    @PostMapping("/api/add-video-user")
    ResponseEntity<UserVideo>  addOrUpdateUserVideo(@RequestBody Map<String,String> req){
        String idUSer = req.get("idUser");
        Video video = vSevice.findVideoByID(req.get("idVideo"));
        User user =  userService.findUserByID(idUSer);
        UserVideoID id = new UserVideoID(user, video);
        UserVideo u = videoService.findUserVideoByID(id);
        if(u == null){
            u = new UserVideo(id, Float.parseFloat(req.get("currentTime")),Float.parseFloat(req.get("totalTime")));
        }
        else {
            u.setCurrentMin(Float.parseFloat(req.get("currentTime")));
            u.setTotalMin(Float.parseFloat(req.get("totalTime")));
        }
        return new ResponseEntity<>(videoService.saveOrUpdateUserVideo(u),HttpStatus.OK);
    }
}
