package com.backend.RedditClone.Repository.CustomRepositoryImp;

import com.backend.RedditClone.Model.CommentWithUsername;
import com.backend.RedditClone.Repository.CustomRepository.CommentCustomRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentCustomRepositoryImp implements CommentCustomRepository {
    @Autowired
    EntityManager em;
    @Override
    public List<CommentWithUsername> getCommentsWithUsernameByPost(String postid) {
        System.out.println(postid);
        String sql = "SELECT rc.*, ru.username,rt.threadname FROM redditcomment rc \n" +
                "\tJOIN reddituser ru ON rc.userid = ru.userid\n" +
                "\tJOIN posts rp ON rc.postid = rp.postid\n" +
                "\tJOIN threads rt ON rp.threadid = rt.threadid\n" +
                "\tWHERE rc.postid = :postid";
        return em.createNativeQuery(sql, CommentWithUsername.class).setParameter("postid", postid).getResultList();
    }
}
