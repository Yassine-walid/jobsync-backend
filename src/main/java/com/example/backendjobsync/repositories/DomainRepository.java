package com.example.backendjobsync.repositories;

import com.example.backendjobsync.entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain,Long> {
}
