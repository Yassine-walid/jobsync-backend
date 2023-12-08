package com.example.backendjobsync.Controllers;

import com.example.backendjobsync.Entities.Announcement;
import com.example.backendjobsync.Entities.Domain;
import com.example.backendjobsync.Entities.Enterprise;
import com.example.backendjobsync.Services.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/domain")
@RequiredArgsConstructor
public class DomainController {

    private final DomainService domainService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDomains(){
        return new ResponseEntity<>(domainService.getAllDomains(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnnouncementById(@PathVariable("id")Long id){
        Optional<?> domain = Optional.ofNullable(domainService.getDomainById(id));

        if(domain.isPresent()){
            return new ResponseEntity<>(domain, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Domain Not Found", HttpStatus.OK);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<?> addDomain(@RequestBody Domain domain) throws Exception{
        return new ResponseEntity<>(domainService.saveDomain(domain),HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateDomain(@PathVariable("id") Long id, @RequestBody Domain domain) throws Exception{
        return new ResponseEntity<>(domainService.updateDomain(domain,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDomain(@PathVariable("id") Long id){
        domainService.deleteDomain(id);
        return ResponseEntity.ok().body("Domain Deleted");
    }
}
