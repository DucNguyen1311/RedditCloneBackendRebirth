package com.backend.RedditClone.Service;

import com.backend.RedditClone.Entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<Post> getPostsByThread(String threadid);
    public List<Post> getPostsByUser(String userid);
    public void savePostToDatabase(Post post);
    public List<Post> getPostsByThreadid(String threadid);
    public Post getPostByPostid(String postid);
}
