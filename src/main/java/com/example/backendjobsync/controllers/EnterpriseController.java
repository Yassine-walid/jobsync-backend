package com.example.backendjobsync.controllers;

import com.example.backendjobsync.entities.Enterprise;

import com.example.backendjobsync.services.EnterpriseService;

import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprise")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EnterpriseController {


    private final EnterpriseService enterpriseService;



    @GetMapping("/all")
    public List<Enterprise> getAllEnterprises(){
        return enterpriseService.getAllEnterprises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Enterprise>> getEnterpriseById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(enterpriseService.getEnterpriseById(id).getBody());
    }

    @PostMapping("/add")
    public Enterprise addEnterprise(@RequestBody Enterprise enterprise) throws Exception{
        return enterpriseService.saveDetails(enterprise);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateEnterprise(@PathVariable("id") Long id, @RequestBody Enterprise enterprise) throws Exception{
        return new ResponseEntity<>(enterpriseService.updateEnterprise(enterprise,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEnterprise(@PathVariable("id") Long id){
        enterpriseService.deleteEnterprise(id);
        return ResponseEntity.ok().body("Enterprise Deleted");
    }

}
