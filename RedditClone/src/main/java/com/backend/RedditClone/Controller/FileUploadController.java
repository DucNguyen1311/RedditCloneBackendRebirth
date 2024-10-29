package com.backend.RedditClone.Controller;

import com.backend.RedditClone.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

@Controller
@RequestMapping("/files")
public class FileUploadController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/uploadFiles")
    public ResponseEntity<?> getUploadedFilesList(@RequestParam("file") MultipartFile file) {
        try {
            storageService.store(file);
            return ResponseEntity.ok().body("Uploaded Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("upload failed");
        }
    }
    @GetMapping("/viewFiles")
    public ResponseEntity<?> getUploadedFiles(@RequestParam("fileName") String fileName) {
        Resource file = storageService.loadAsResource(fileName);
        return (file == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(file);
    }
}
