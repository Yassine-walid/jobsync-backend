package com.example.backendjobsync.Services;

import com.example.backendjobsync.Entities.Domain;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DomainService {
    ResponseEntity<List<Domain>> getAllDomains();

    ResponseEntity<?> getDomainById(Long id);
    ResponseEntity<?> saveDomain(Domain domain);

    ResponseEntity<?> updateDomain(Domain newDataDomain,Long id);
    ResponseEntity<?> deleteDomain(Long id);
}
