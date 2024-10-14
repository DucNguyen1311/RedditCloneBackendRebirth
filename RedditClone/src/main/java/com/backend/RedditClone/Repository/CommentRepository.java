package com.backend.RedditClone.Repository;

import com.backend.RedditClone.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    public List<Comment> findCommentsByPostid(String postid);
    public List<Comment> findCommentsByUserId(String userId);
}
