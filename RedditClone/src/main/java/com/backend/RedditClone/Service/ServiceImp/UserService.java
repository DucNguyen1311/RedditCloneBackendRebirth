package com.backend.RedditClone.Service.ServiceImp;

import com.backend.RedditClone.Entity.User;
import com.backend.RedditClone.Payload.RegisterRequest;
import com.backend.RedditClone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements com.backend.RedditClone.Service.UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int saveUserToDatabase (RegisterRequest registerRequest) {
        if (userRepository.findAccountByEmail(registerRequest.getEmail()) != null) {
            return 3;
        } else {
            userRepository.save(new User(new BCryptPasswordEncoder().encode(registerRequest.getPassword()), registerRequest.getEmail()));
            return 0;
        }
    }
}
