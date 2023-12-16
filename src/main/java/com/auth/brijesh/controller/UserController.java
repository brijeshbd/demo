package com.auth.brijesh.controller;

import com.auth.brijesh.model.request.UserRequest;
import com.auth.brijesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Testing Sucessfully");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/save")
    public ResponseEntity<String> addUser(@RequestBody UserRequest userRequest){
        userService.saveUser(userRequest);
        return ResponseEntity.ok("Added...");
    }

}
