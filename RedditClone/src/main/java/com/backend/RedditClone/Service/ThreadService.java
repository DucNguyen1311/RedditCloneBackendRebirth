package com.backend.RedditClone.Service;

import com.backend.RedditClone.Entity.Thread;
import com.backend.RedditClone.Model.SearchThreadByKeywordResponseModel;
import com.backend.RedditClone.Payload.ThreadRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThreadService {
    int saveThreadToDatabase(ThreadRequest threadRequest);
    List<?> getThreadsByKeyword(String name);
    List<?> getThreadsByKeywordAndPage(String keyword, int page);
}
