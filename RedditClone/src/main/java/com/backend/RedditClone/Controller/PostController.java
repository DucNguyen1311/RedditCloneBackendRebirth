package com.backend.RedditClone.Controller;

import com.backend.RedditClone.DTO.PostDTO;
import com.backend.RedditClone.Entity.Post;
import com.backend.RedditClone.Payload.PostRequest;
import com.backend.RedditClone.Repository.PostRepository;
import com.backend.RedditClone.Service.CommentService;
import com.backend.RedditClone.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody PostRequest postRequest) {
        try {
            postService.savePostToDatabase(new Post(postRequest));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getallpostfromthread")
    public ResponseEntity<?> getAllPostFromThread(@RequestParam String threadName) {
        try {
            return ResponseEntity.ok().body(postService.getPostsByThread(threadName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getpostfromuserid")
    public ResponseEntity<?> getAllPostFromUser(@RequestBody String userId) {
        try {
            return ResponseEntity.ok().body(postService.getPostsByUser(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getpost")
    public ResponseEntity<?> getPost(@RequestParam String postId) {
        try {
            return ResponseEntity.ok().body(postService.getPostByPostid(postId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getpostfromthreadid")
    public ResponseEntity<?> getPostFromThread(@RequestParam String threadId) {
        try {
            return ResponseEntity.ok().body(postService.getPostsByThreadid(threadId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getpostDTO")
    public ResponseEntity<?> getPostDTO(@RequestParam String postId) {
        try {
            PostDTO postDTO = new PostDTO(
                    postService.getPostByPostid(postId),
                    commentService.getCommentTreeFromPostId(postId)
            );
            return ResponseEntity.ok().body(postDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
