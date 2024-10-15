package com.backend.RedditClone.DTO;

import com.backend.RedditClone.Entity.Post;
import com.backend.RedditClone.Entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class ThreadDTO {
    private List<Post> postList;
    private Thread thread;
    private List<User> moderators;
    private Integer members;
}
