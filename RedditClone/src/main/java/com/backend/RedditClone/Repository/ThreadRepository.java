package com.backend.RedditClone.Repository;

import com.backend.RedditClone.Entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, String> {
    public Thread findThreadByName(String name);
}
