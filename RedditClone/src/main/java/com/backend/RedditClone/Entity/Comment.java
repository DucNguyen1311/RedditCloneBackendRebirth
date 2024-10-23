package com.backend.RedditClone.Entity;


import com.backend.RedditClone.Payload.CommentRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="redditcomment")
@NonNull
@ToString
public class Comment {
    @Id
    @Column(name = "commentid")
    private String commentId;
    @Column(name = "userid")
    private String userId;
    @Column(name = "postid")
    private String postid;
    @Column(name = "cakedate")
    private Instant cakedate;
    @Column(name = "commentbody")
    private String content;
    @Column(name = "parent")
    private String parent;
    @Column(name = "karma")
    private int karma;

    public Comment (CommentRequest commentRequest) {
        this.commentId = UUID.randomUUID().toString().replace("-", "");
        this.userId = commentRequest.getUserid();
        this.postid = commentRequest.getPostid();
        this.cakedate = Instant.now().truncatedTo(
                java.time.temporal.ChronoUnit.SECONDS
        );
        this.content = commentRequest.getContent();
        this.parent = commentRequest.getParent().isEmpty() ? this.commentId : commentRequest.getParent();
        this.karma = 0;
    }
}
