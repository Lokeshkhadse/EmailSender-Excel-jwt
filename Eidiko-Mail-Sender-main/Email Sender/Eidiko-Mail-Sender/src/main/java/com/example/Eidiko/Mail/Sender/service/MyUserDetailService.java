package com.example.Eidiko.Mail.Sender.service;

import com.example.Eidiko.Mail.Sender.Repository.JwtRepository;
import com.example.Eidiko.Mail.Sender.model.JwtUser;
import com.example.Eidiko.Mail.Sender.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private JwtRepository jwtRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser jwtUser = jwtRepository.findByUsername(username);
        if (jwtUser == null) {
            System.out.println("Jwt user not found");
            throw new UsernameNotFoundException("jwt user not found");
        }
        return new UserPrinciple(jwtUser);
    }

}
