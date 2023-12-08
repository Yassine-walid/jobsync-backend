package com.example.backendjobsync.Controllers;

import com.example.backendjobsync.Entities.Domain;
import com.example.backendjobsync.Entities.Post;
import com.example.backendjobsync.Services.DomainService;
import com.example.backendjobsync.Services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id")Long id){
        Optional<?> post = Optional.ofNullable(postService.getPostById(id));

        if(post.isPresent()){
            return new ResponseEntity<>(post, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Post Not Found", HttpStatus.OK);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody Post post) throws Exception{
        return new ResponseEntity<>(postService.savePost(post),HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id") Long id, @RequestBody Post post) throws Exception{
        return new ResponseEntity<>(postService.updatePost(post,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
        return ResponseEntity.ok().body("Post Deleted");
    }
}
