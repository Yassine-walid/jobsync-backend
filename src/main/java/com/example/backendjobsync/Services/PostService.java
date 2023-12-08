package com.example.backendjobsync.Services;

import com.example.backendjobsync.Entities.Announcement;
import com.example.backendjobsync.Entities.Enterprise;
import com.example.backendjobsync.Entities.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {

    ResponseEntity<List<Post>> getAllPosts();
    ResponseEntity<Post> savePost(Post post) throws Exception;

    ResponseEntity<?> getPostById(Long id);

    ResponseEntity<?> updatePost(Post newDataPost,Long id);
    ResponseEntity<String> deletePost(Long id);
}
