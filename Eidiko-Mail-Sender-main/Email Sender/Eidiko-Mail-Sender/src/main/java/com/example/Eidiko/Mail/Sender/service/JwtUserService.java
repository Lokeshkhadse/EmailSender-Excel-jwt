package com.example.Eidiko.Mail.Sender.service;

import com.example.Eidiko.Mail.Sender.model.JwtUser;

import java.util.List;


public interface JwtUserService {

    public JwtUser create(JwtUser jwtUser) ;

    List<JwtUser> getallusers();

    public String verify(JwtUser jwtUser);
}
