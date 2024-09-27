package com.example.Eidiko.Mail.Sender.Repository;

import com.example.Eidiko.Mail.Sender.model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRepository extends JpaRepository<JwtUser , Integer> {
    JwtUser findByUsername(String username);

}
