package com.backend.RedditClone.Controller;

import com.backend.RedditClone.Entity.User;
import com.backend.RedditClone.Repository.UserRepository;
import com.backend.RedditClone.Security.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @GetMapping("/")
    public ResponseEntity<User> getUserInfo(@RequestHeader(name = "Authorization") String token) {
        User account = userRepository.findAccountByUsername(jwtTokenUtil.getUsernameFromToken(token.replace("Bearer ", "")));
        if (account == null) {
            return (ResponseEntity<User>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(account);
    }
}
