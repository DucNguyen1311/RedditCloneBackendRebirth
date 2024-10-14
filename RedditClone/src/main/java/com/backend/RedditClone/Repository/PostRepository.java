package com.backend.RedditClone.Repository;

import com.backend.RedditClone.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    public List<Post> findAllByThreadid(String threadid);
    public List<Post> findPostsByUserid(String userid);
}
