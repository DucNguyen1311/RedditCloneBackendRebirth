package com.backend.RedditClone.Controller;

import com.backend.RedditClone.Payload.ThreadRequest;
import com.backend.RedditClone.Service.ThreadService;
import com.backend.RedditClone.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadController {
    @Autowired
    ThreadService threadService;
    @PostMapping("/add")
    public ResponseEntity<?> addThread(@RequestBody ThreadRequest threadRequest) {
        try{
            threadService.saveThreadToDatabase(threadRequest);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search/{keyword}/{pages}")
    public ResponseEntity<?> searchThread(@PathVariable String keyword) {
        try {
            List<?> result = threadService.getThreadsByKeyword(keyword);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
