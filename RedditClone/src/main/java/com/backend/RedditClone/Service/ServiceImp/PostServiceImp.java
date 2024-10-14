package com.backend.RedditClone.Service.ServiceImp;

import com.backend.RedditClone.Entity.Post;
import com.backend.RedditClone.Repository.CustomRepository.PostCustomRepository;
import com.backend.RedditClone.Repository.PostRepository;
import com.backend.RedditClone.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostCustomRepository customRepository;

    @Override
    public List<Post> getPostsByThread(String threadName) {
        System.out.println(threadName);
        return customRepository.findAllPostsByThreadName(threadName);
    }


    @Override
    public List<Post> getPostsByUser(String userid) {
        return postRepository.findPostsByUserid(userid);
    }

    @Override
    public void savePostToDatabase(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getPostsByThreadid(String threadid) {
        return customRepository.findPostsByThreadID(threadid);
    }

    @Override
    public Post getPostByPostid(String postid) {
        return customRepository.findPostByPostid(postid);
    }
}
