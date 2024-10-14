package com.backend.RedditClone.Security;

import com.backend.RedditClone.Entity.User;
import com.backend.RedditClone.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;

@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean valid = EmailValidator.getInstance().isValid(username);
        User u;
        System.out.println("sub");
        if (valid) {
            u = userRepository.findAccountByEmail(username);
        } else {
            u = userRepository.findAccountByUsername(username);
        }
        if (u == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new UserDetail(u);
        }
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new UserDetail(user);
    }
}
