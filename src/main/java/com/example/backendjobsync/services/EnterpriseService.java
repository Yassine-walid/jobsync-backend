package com.example.backendjobsync.services;

import com.example.backendjobsync.entities.Enterprise;
import org.springframework.http.ResponseEntity;



import java.util.List;
import java.util.Optional;



public interface EnterpriseService {



    List<Enterprise> getAllEnterprises();
    Enterprise saveDetails(Enterprise enterprise) throws Exception;

    ResponseEntity<Optional<Enterprise>> getEnterpriseById( Long id);

    ResponseEntity<?> updateEnterprise(Enterprise newDataEnterprise,Long id);
    ResponseEntity<String> deleteEnterprise(Long id);

}
