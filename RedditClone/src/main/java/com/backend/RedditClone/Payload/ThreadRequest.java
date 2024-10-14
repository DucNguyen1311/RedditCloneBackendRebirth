package com.backend.RedditClone.Payload;


import jakarta.persistence.Column;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class ThreadRequest {
    private String name;
    private String description;
    private String rules;
    private String categories;
    private Boolean isPublic;
}
