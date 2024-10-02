package com.backend.RedditClone.Payload;

import lombok.Data;

@Data
public class RegisterRequest {
    private String password;    
    private String email;

    public RegisterRequest(){};
    public RegisterRequest(String password, String email) {
        this.email = email;
        this.password = password;
    }
}
