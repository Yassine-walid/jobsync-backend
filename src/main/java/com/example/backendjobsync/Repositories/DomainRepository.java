package com.example.backendjobsync.Repositories;

import com.example.backendjobsync.Entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain,Long> {
}
