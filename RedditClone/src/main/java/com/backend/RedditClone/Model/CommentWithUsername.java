package com.backend.RedditClone.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentWithUsername {
    private String commentId;
    private String userId;
    private String postid;
    private java.sql.Timestamp cakedate;
    private String content;
    private String parent;
    private int karma;
    private String username;
    private String threadname;
}
