package com.example.backendjobsync.Controllers;

import com.example.backendjobsync.Entities.Enterprise;
import com.example.backendjobsync.Services.EnterpriseService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
@RequiredArgsConstructor
public class EnterpriseController {


    private final EnterpriseService enterpriseService;



    @GetMapping("/all")
    public List<Enterprise> getAllEnterprises(){
        return enterpriseService.getAllEnterprises();
    }
}
