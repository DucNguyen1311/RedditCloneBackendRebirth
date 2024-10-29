package com.backend.RedditClone.Service.ServiceImp;

import com.backend.RedditClone.Exception.StorageException;
import com.backend.RedditClone.Properties.StorageProperties;
import com.backend.RedditClone.Service.StorageService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Getter
@Setter
@Service
public class StorageServiceImp implements StorageService {

    private final Path rootLocation;

    @Autowired
    public StorageServiceImp(StorageProperties properties) {

        if(properties.getLocation().trim().isEmpty()){
            throw new StorageException("File upload location can not be Empty.");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init(){
    }

    @Override
    public void store(MultipartFile file) {
        System.out.println("Heyyy");
        try {
            if (file.isEmpty()) {
                System.out.println("Failed to store empty file.");
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                System.out.println("Cannot store file outside current directory.");
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            System.out.println("Failed to store file.");
            throw new StorageException("Failed to store file.", e);
        }

    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }
}
