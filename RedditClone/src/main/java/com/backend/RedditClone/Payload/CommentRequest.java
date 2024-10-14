package com.backend.RedditClone.Payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@NonNull
public class CommentRequest {
    private String postid;
    private String userid;
    private String content;
    private String parent;

    public CommentRequest(String postid, String userid, String content, String parent) {
        this.postid = postid;
        this.userid = userid;
        this.content = content;
        this.parent = parent;
    }
}
