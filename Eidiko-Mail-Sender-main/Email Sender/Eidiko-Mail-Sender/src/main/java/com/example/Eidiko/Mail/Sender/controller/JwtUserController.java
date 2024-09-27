package com.example.Eidiko.Mail.Sender.controller;

import com.example.Eidiko.Mail.Sender.model.JwtUser;
import com.example.Eidiko.Mail.Sender.service.JwtUserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwtuser")
public class JwtUserController {

    @Autowired
    private JwtUserService jwtUserService;

    @PostMapping("/register")
    public ResponseEntity<JwtUser> create(@RequestBody JwtUser jwtUser){
        return new ResponseEntity<>(jwtUserService.create(jwtUser), HttpStatus.CREATED);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<JwtUser>>getusers(){
        return new ResponseEntity<>(jwtUserService.getallusers(),HttpStatus.FOUND);
    }

    @PostMapping("/login")
    public String login(@RequestBody JwtUser jwtUser){
        return jwtUserService.verify(jwtUser);
    }
}
