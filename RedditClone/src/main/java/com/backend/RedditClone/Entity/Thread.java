package com.backend.RedditClone.Entity;

import com.backend.RedditClone.Payload.ThreadRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "threads")
@NonNull
public class Thread {
    @Id
    @Column(name = "threadid")
    private String id;
    @Column(name = "threadname")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "rules")
    private String rules;
    @Column(name ="categories")
    private String categories;
    @Column(name = "cakedate")
    private Instant cakeDate;
    @Column(name = "is_public")
    private Boolean isPublic;
    @Column(name="avatarpath")
    private String avatarpath;
    @Column(name="wallpath")
    private String wallpath;
    @Column(name="popularity")
    private Integer popularity;

    public Thread(String name, String description, String rules, String categories, java.sql.Date cakeDate, Boolean isPublic) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.categories = categories;
        this.cakeDate = Instant.now().truncatedTo(
                java.time.temporal.ChronoUnit.SECONDS
        );
        this.isPublic = isPublic;
    }

    public Thread(ThreadRequest threadRequest) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = "r/" + threadRequest.getName();
        this.description = threadRequest.getDescription();
        this.rules = threadRequest.getRules();
        this.categories = threadRequest.getCategories();
        this.cakeDate = Instant.now().truncatedTo(
                java.time.temporal.ChronoUnit.SECONDS
        );
        this.isPublic = threadRequest.getIsPublic();
        this.avatarpath = "./public/images/" + threadRequest.getName() + "avatar.png";
        this.wallpath = "./public/images/" + threadRequest.getName() + "wall.png";
        this.popularity = 0;
    }
}
