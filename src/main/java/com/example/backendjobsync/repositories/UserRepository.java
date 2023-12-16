package com.example.backendjobsync.repositories;

import com.example.backendjobsync.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
