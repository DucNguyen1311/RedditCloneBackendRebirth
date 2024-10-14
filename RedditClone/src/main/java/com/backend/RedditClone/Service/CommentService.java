package com.backend.RedditClone.Service;

import com.backend.RedditClone.Entity.Comment;
import com.backend.RedditClone.Model.CommentTree;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public CommentTree getCommentTreeFromPostId(String postId);
    public void saveComment(Comment comment);
}
