package com.example.backendjobsync.Repositories;

import com.example.backendjobsync.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
