package com.example.backendjobsync.repositories;

import com.example.backendjobsync.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {


}
