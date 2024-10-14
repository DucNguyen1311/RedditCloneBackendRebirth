package com.backend.RedditClone.Controller;

import com.backend.RedditClone.Payload.RegisterRequest;
import com.backend.RedditClone.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerNewAccount(@RequestBody RegisterRequest registerRequest) {
        try {
            int flag = userService.saveUserToDatabase(registerRequest);
            if (flag != 0) {
                return ResponseEntity.badRequest().body(flag);
            } else {
                return ResponseEntity.ok(registerRequest);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Account Creation Failure for some reason...");
        }
    }
}
