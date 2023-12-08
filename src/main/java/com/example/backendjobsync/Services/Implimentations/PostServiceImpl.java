package com.example.backendjobsync.Services.Implimentations;

import com.example.backendjobsync.Entities.Post;
import com.example.backendjobsync.Repositories.PostRepository;
import com.example.backendjobsync.Services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Override
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok().body(postRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return new ResponseEntity<>(post,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("Post Not Fount",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Post> savePost(Post post) throws Exception {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updatePost(Post newDataPost, Long id) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isPresent()){

            Post postUpdate = post.get();

            postUpdate.setTitle(newDataPost.getTitle());
            postUpdate.setDescription(newDataPost.getDescription());
            postUpdate.setBannerUrl(newDataPost.getBannerUrl());
            postRepository.save(postUpdate);
            return new ResponseEntity<>(postUpdate,HttpStatus.ACCEPTED);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Post Not modified");
        }
    }

    @Override
    public ResponseEntity<String> deletePost(Long id) {
        postRepository.deleteById(id);
        return new ResponseEntity<>("Post deleted",HttpStatus.ACCEPTED);
    }
}
