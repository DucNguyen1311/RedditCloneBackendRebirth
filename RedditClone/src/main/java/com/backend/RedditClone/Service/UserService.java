package com.backend.RedditClone.Service;

import com.backend.RedditClone.Entity.User;
import com.backend.RedditClone.Payload.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
    if the username is taken, this function will return 1.
    if the email is taken, this function will return 2.
    if account saved succesfully, return 0;
     **/
    int saveUserToDatabase(RegisterRequest registerRequest);
    User findUserByUsername(String username);
}
