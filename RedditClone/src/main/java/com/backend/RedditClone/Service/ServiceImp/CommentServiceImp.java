package com.backend.RedditClone.Service.ServiceImp;

import com.backend.RedditClone.Entity.Comment;
import com.backend.RedditClone.Model.CommentTree;
import com.backend.RedditClone.Model.CommentWithUsername;
import com.backend.RedditClone.Repository.CommentRepository;
import com.backend.RedditClone.Repository.CustomRepository.CommentCustomRepository;
import com.backend.RedditClone.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentCustomRepository commentCustomRepository;

    @Override
    public CommentTree getCommentTreeFromPostId(String postId) {
        List<CommentWithUsername> commentWithUsernames  = commentCustomRepository.getCommentsWithUsernameByPost(postId);
        String firstNodeID = "";
        Map<String, CommentTree> commentTreeMap = new HashMap<>();
        for(CommentWithUsername comment : commentWithUsernames) {
            commentTreeMap.put(comment.getCommentId(), new CommentTree(comment));
            if (Objects.equals(comment.getParent(), comment.getCommentId())) {
                firstNodeID = comment.getCommentId();
            }
        }
        for(CommentWithUsername comment : commentWithUsernames) {
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
