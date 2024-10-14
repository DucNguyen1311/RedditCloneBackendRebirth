package com.backend.RedditClone.Controller;

import com.backend.RedditClone.Entity.Comment;
import com.backend.RedditClone.Payload.CommentRequest;
import com.backend.RedditClone.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addcomment")
    public ResponseEntity<?> saveComment(@RequestBody CommentRequest commentRequest) {
        try {
            commentService.saveComment(new Comment(commentRequest));
            return ResponseEntity.ok().body("Comment Added");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
