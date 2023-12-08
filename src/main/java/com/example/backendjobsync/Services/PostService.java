package com.example.backendjobsync.Services;


import com.example.backendjobsync.Entities.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PostService {

    ResponseEntity<List<Post>> getAllPosts();
    ResponseEntity<Post> savePost(Post post) throws Exception;

    ResponseEntity<?> getPostById(Long id);

    ResponseEntity<?> updatePost(Post newDataPost,Long id);
    ResponseEntity<String> deletePost(Long id);
}
