package com.backend.RedditClone.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String postcontent;
    private String tags;
    private String threadid;
    private String userid;
}
