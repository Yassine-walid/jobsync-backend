package com.example.backendjobsync.Controllers;

import com.example.backendjobsync.Entities.Enterprise;

import com.example.backendjobsync.Services.EnterpriseService;

import lombok.RequiredArgsConstructor;



import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enterprise")
@RequiredArgsConstructor
public class EnterpriseController {


    private final EnterpriseService enterpriseService;



    @GetMapping("/all")
    public List<Enterprise> getAllEnterprises(){
        return enterpriseService.getAllEnterprises();
    }

    @PostMapping("/add")
    public Enterprise addEnterprise(@RequestBody Enterprise enterprise) throws Exception{
        return enterpriseService.saveDetails(enterprise);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEnterprise(@PathVariable UUID id) {
        return enterpriseService.deleteEnterprise(id);
    }
}
