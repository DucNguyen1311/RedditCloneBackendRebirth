package com.backend.RedditClone.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchThreadByKeywordResponseModel {
    private String threadname;
    private String threadid;
    private String description;
    private java.sql.Date cakedate;
    private long membercount;
}
