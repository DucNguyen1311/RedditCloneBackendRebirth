package com.backend.RedditClone.Service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public interface StorageService {
    public void init();
    public void store(MultipartFile file);
    public Path load(String filename);
    public Resource loadAsResource(String filename);
}
