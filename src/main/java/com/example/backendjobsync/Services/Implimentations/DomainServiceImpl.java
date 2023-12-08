package com.example.backendjobsync.Services.Implimentations;


import com.example.backendjobsync.Entities.Domain;
import com.example.backendjobsync.Repositories.DomainRepository;
import com.example.backendjobsync.Services.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {
    private DomainRepository domainRepository;

    @Override
    public ResponseEntity<List<Domain>> getAllDomains(){
        return ResponseEntity.ok().body(domainRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getDomainById(Long id){
        Optional<Domain> domain = domainRepository.findById(id);
        if(domain.isPresent()){
            return new ResponseEntity<>(domain,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("Domain Not Fount",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> saveDomain(Domain domain){
        return new ResponseEntity<>(domainRepository.save(domain), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateDomain(Domain newDataDomain,Long id){
        Optional<Domain> domain = domainRepository.findById(id);

        if(domain.isPresent()){

            Domain domainUpdate = domain.get();

            domainUpdate.setName(newDataDomain.getName());
            domainRepository.save(domainUpdate);
            return new ResponseEntity<>(domainUpdate,HttpStatus.ACCEPTED);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Domain Not modified");
        }
    }

    @Override
    public ResponseEntity<?> deleteDomain(Long id) {
        domainRepository.deleteById(id);
        return new ResponseEntity<>("Domain deleted",HttpStatus.ACCEPTED);
    }
}
