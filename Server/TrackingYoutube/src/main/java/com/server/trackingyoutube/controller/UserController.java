package com.server.trackingyoutube.controller;

import com.server.trackingyoutube.entity.User;
import com.server.trackingyoutube.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/get-user")
    ResponseEntity<Map<String,Boolean>> getUserByID(@RequestParam("id") String id){
        Map<String,Boolean> res = new HashMap<>();
        User u = userService.findUserByID(id);
        if (u == null){
            res.put("response", false);
        }
        else{
            res.put("response", true);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/api/add-user")
    ResponseEntity<User>  addOrUpdateUser(@RequestBody User u ){
        User user = userService.findUserByID(u.getId());
        if(user ==null){
            user = new User(u.getId(),u.getEmail());
        }
        else {
            user.setEmail(u.getEmail());
        }
        return  new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
}
