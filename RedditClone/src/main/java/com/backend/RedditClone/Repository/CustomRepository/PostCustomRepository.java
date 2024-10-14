package com.backend.RedditClone.Repository.CustomRepository;

import com.backend.RedditClone.Entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostCustomRepository {
    public List<Post> findAllPostsByThreadName(String threadName);
    public Post findPostByPostid(String postid);
    public List<Post> findPostsByThreadID(String threadID);
}
