package com.backend.RedditClone.Repository;

import com.backend.RedditClone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findAccountByUsername(String username);
    User findAccountByEmail(String email);
}
