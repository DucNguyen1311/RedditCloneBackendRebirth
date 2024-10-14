package com.backend.RedditClone.Repository.CustomRepositoryImp;

import com.backend.RedditClone.Entity.Post;
import com.backend.RedditClone.Repository.CustomRepository.PostCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostCustomRepositoryImp implements PostCustomRepository {
    @Autowired
    private EntityManager em;
    @Override
    public List<Post> findAllPostsByThreadName(String threadName) {
        String sql = "SELECT pst.* FROM posts pst JOIN threads thr ON pst.threadid = thr.threadid WHERE thr.threadname = :threadName";
        Query query = em.createNativeQuery(sql, Post.class).setParameter("threadName", threadName);
        return query.getResultList();
    }

    @Override
    public List<Post> findPostsByThreadID(String threadID) {
        String sql = "SELECT * FROM posts WHERE threadid = :threadID";
        Query query = em.createNativeQuery(sql, Post.class).setParameter("threadID", threadID);
        return query.getResultList();
    }

    @Override
    public Post findPostByPostid(String PostID) {
        String slq = "SELECT * FROM posts WHERE postid = :PostID";
        Query query = em.createNativeQuery(slq, Post.class).setParameter("PostID", PostID);
        return (Post) query.getResultList().getFirst();
    }
}
