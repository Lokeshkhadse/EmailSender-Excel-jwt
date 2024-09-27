package com.example.Eidiko.Mail.Sender.service;

import com.example.Eidiko.Mail.Sender.Repository.JwtRepository;
import com.example.Eidiko.Mail.Sender.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserServiceImpl implements JwtUserService {


    @Autowired
    private JwtRepository jwtRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Override
    public JwtUser create(JwtUser jwtUser) {
        jwtUser.setPassword(encoder.encode(jwtUser.getPassword()));
         return jwtRepository.save(jwtUser);
    }

    @Override
    public List<JwtUser> getallusers() {
        return jwtRepository.findAll();
    }
    @Override
    public String verify(JwtUser jwtUser) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtUser.getUsername(), jwtUser.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(jwtUser.getUsername());
        } else {
            return "fail";
        }
    }

}
