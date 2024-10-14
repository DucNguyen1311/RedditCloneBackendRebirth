package com.backend.RedditClone.Controller;

import java.util.Objects;

import com.backend.RedditClone.DTO.AuthorizationDTO;
import com.backend.RedditClone.Repository.UserRepository;
import com.backend.RedditClone.Security.AccountDetailService;
import com.backend.RedditClone.Security.JwtRequest;
import com.backend.RedditClone.Security.JwtResponse;
import com.backend.RedditClone.Security.JwtTokenUtil;
import com.backend.RedditClone.Service.ServiceImp.UserServiceImp;
import com.backend.RedditClone.Service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountDetailService accountDetailService;

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = accountDetailService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);
            AuthorizationDTO dto = new AuthorizationDTO(token, userService.findUserByUsername(jwtTokenUtil.getUsernameFromToken(token)).getId());
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("1", e);
        } catch (BadCredentialsException e) {
            throw new Exception("2", e);
        }
    }
}