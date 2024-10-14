package com.backend.RedditClone.Repository.CustomRepositoryImp;

import com.backend.RedditClone.Entity.Thread;
import com.backend.RedditClone.Model.SearchThreadByKeywordResponseModel;
import com.backend.RedditClone.Repository.CustomRepository.ThreadCustomRepository;
import com.backend.RedditClone.Repository.ThreadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadCustomRepositoryImp implements ThreadCustomRepository {
    @Autowired
    public EntityManager entityManager;

    @Override
    public List<?> findAllMatchingThreadsByKeyword(String keyword) {
        String para1 = '%' + keyword + '%';
        String para2 = keyword + '%';
        String sql = "SELECT * \n" +
                "FROM (\n" +
                "    SELECT DISTINCT threadname, threadid, description, cakedate, \n" +
                "\t(SELECT count(userid) from threadmember where threadmember.threadid = threads.threadid) as membercount\n" +
                "    FROM threads threads\n" +
                "    WHERE threadname ILIKE :para1\n" +
                "    ) alias\n" +
                "ORDER BY threadname ILIKE :para2 DESC, threadname\n" +
                "LIMIT 10";
        return entityManager.createNativeQuery(sql, SearchThreadByKeywordResponseModel.class)
                .setParameter("para1", para1).setParameter("para2", para2).getResultList();
    }

    @Override
    public List<?> findAllMatchingThreadsByKeywordAndPage(String keyword, int page) {
        String para1 = '%' + keyword + '%';
        String para2 = keyword + '%';
        page = (page - 1) * 5;
        String sql = "SELECT * \n" +
                "FROM (\n" +
                "    SELECT DISTINCT threadname, threadid, description, cakedate, \n" +
                "\t(SELECT count(userid) from threadmember where threadmember.threadid = threads.threadid) as membercount\n" +
                "    FROM threads threads\n" +
                "    WHERE threadname ILIKE :para1\n" +
                "    ) alias\n" +
                "ORDER BY threadname ILIKE :para2 DESC, threadname\n" +
                "LIMIT 10 OFFSET :page";
        return entityManager.createNativeQuery(sql, SearchThreadByKeywordResponseModel.class)
                .setParameter("para1", para1).setParameter("para2", para2).setParameter("page", page)
                .getResultList();
    }
}