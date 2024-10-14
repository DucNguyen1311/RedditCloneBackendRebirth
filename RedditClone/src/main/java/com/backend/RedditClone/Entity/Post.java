package com.backend.RedditClone.Entity;

import com.backend.RedditClone.Payload.PostRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
@NonNull
public class Post {
    @Id
    @Column(name = "postid")
    private String postid;
    @Column(name = "userid")
    private String userid;
    @Column(name = "threadid")
    private String threadid;
    @Column(name = "title")
    private String title;
    @Column(name = "postcontent")
    private String postcontent;
    @Column(name = "tags")
    private String tags;
    @Column(name = "cakedate")
    private Instant cakedate;
    @Column(name = "karma")
    private Integer karma;

    public Post(PostRequest postRequest) {
        this.postid = UUID.randomUUID().toString().replace("-", "");
        this.userid = postRequest.getUserid();
        this.threadid = postRequest.getThreadid();
        this.title = postRequest.getTitle();
        this.postcontent = postRequest.getPostcontent();
        this.tags = postRequest.getTags();
        this.cakedate = Instant.now().truncatedTo(
                java.time.temporal.ChronoUnit.SECONDS
        );
        this.karma = 0;
    }
}
