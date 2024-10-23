package com.backend.RedditClone.Repository.CustomRepository;

import com.backend.RedditClone.Model.CommentWithUsername;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentCustomRepository {
    public List<CommentWithUsername> getCommentsWithUsernameByPost(String postid);
}
