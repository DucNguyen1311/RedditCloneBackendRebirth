package com.backend.RedditClone.DTO;

import com.backend.RedditClone.Entity.Post;
import com.backend.RedditClone.Model.CommentTree;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @NonNull
    private Post post;
    private CommentTree commentTree;
}
