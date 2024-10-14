package com.backend.RedditClone.Service.ServiceImp;

import com.backend.RedditClone.Entity.Thread;
import com.backend.RedditClone.Model.SearchThreadByKeywordResponseModel;
import com.backend.RedditClone.Payload.ThreadRequest;
import com.backend.RedditClone.Repository.CustomRepository.ThreadCustomRepository;
import com.backend.RedditClone.Repository.ThreadRepository;
import com.backend.RedditClone.Service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImp implements ThreadService {
    @Autowired
    private ThreadRepository threadRepository;
    @Autowired
    private ThreadCustomRepository threadCustomRepository;
    @Override
    public int saveThreadToDatabase(ThreadRequest threadRequest) {
        try {
            Thread thread = new Thread(threadRequest);
            threadRepository.save(thread);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public List<?> getThreadsByKeyword(String keyword) {
        try {
            return threadCustomRepository.findAllMatchingThreadsByKeyword(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<?> getThreadsByKeywordAndPage(String keyword, int page) {
        try {
            return threadCustomRepository.findAllMatchingThreadsByKeywordAndPage(keyword, page);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
