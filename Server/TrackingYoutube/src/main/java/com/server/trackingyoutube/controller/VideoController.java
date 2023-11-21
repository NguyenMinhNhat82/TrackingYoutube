package com.server.trackingyoutube.controller;

import com.server.trackingyoutube.entity.Video;
import com.server.trackingyoutube.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;
    @PostMapping("/api/add-video")
    public ResponseEntity<Video> addOrUpdateVideo(@RequestBody Video v){
        Video video = videoService.findVideoByID(v.getId());
        if(video == null){
            video = new Video(v.getId(),v.getName());
        }
        else{
            video.setName(v.getName());
        }
        return new ResponseEntity<>(videoService.saveOrUpDateVideo(video), HttpStatus.OK);

    }
    @GetMapping("/api/get-video")
    ResponseEntity<Map<String,Boolean>> getVideoByID(@RequestParam("id") String Id){
        Video v = videoService.findVideoByID(Id);
        Map<String,Boolean> res = new HashMap();
        if (v == null){
            res.put("response",false);
        }
        else {
            res.put("response",true);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }
}
