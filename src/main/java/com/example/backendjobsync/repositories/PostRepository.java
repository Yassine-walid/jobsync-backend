package com.example.backendjobsync.repositories;

import com.example.backendjobsync.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
