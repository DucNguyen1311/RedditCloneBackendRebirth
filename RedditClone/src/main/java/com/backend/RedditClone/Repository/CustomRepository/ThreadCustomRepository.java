package com.backend.RedditClone.Repository.CustomRepository;

import com.backend.RedditClone.Entity.Thread;

import java.util.List;

public interface ThreadCustomRepository {
    public List<?> findAllMatchingThreadsByKeyword(String keyword);
    public List<?> findAllMatchingThreadsByKeywordAndPage(String keyword, int page);
}
