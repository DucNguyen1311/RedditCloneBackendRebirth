package com.backend.RedditClone.Entity;

import com.backend.RedditClone.Utility.NameGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static java.awt.Color.blue;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reddituser")
@NonNull
public class User {
    @Id @Column(name = "userid")
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "userpassword")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name ="cakedate")
    private Instant cakeDate;
    @Column (name="karma")
    private Integer karma;
    @Column (name="avatarpath")
    private String avatarPath;

    public User(String password, String email) {
        NameGenerator generator = new NameGenerator();
        this.username = generator.generateName();
        this.password = password;
        this.email = email;
        this.cakeDate = Instant.now().truncatedTo(
                java.time.temporal.ChronoUnit.SECONDS
        );
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.karma = 0;
        this.avatarPath = "./public/images/" + username + ".png";
    }

}
