package com.backend.RedditClone.Properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Component
@ConfigurationProperties("storage")
@Getter
public class StorageProperties {
    private String location = "RedditClone//src//main//files";
}
