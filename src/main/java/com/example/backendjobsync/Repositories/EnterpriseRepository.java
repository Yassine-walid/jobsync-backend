package com.example.backendjobsync.Repositories;

import com.example.backendjobsync.Entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {


}
