package com.backend.RedditClone.Service.ServiceImp;

import com.backend.RedditClone.Entity.Comment;
import com.backend.RedditClone.Model.CommentTree;
import com.backend.RedditClone.Repository.CommentRepository;
import com.backend.RedditClone.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentTree getCommentTreeFromPostId(String postId) {
        List<Comment> comments = commentRepository.findCommentsByPostid(postId);
        String firstNodeID = "";
        Map<String, CommentTree> commentTreeMap = new HashMap<>();
        for(Comment comment : comments) {
            commentTreeMap.put(comment.getCommentId(), new CommentTree(comment));
            if (Objects.equals(comment.getParent(), comment.getCommentId())) {
                firstNodeID = comment.getCommentId();
            }
        }
        for(Comment comment : comments) {
            if (!Objects.equals(comment.getParent(), comment.getCommentId())) {
                commentTreeMap.get(comment.getParent()).addCommentTree(commentTreeMap.get(comment.getCommentId()));
            }
        }
        return commentTreeMap.get(firstNodeID);
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
