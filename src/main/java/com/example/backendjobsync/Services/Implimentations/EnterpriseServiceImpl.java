package com.example.backendjobsync.Services.Implimentations;

import com.example.backendjobsync.Entities.Enterprise;
import com.example.backendjobsync.Repositories.EnterpriseRepository;
import com.example.backendjobsync.Services.EnterpriseService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {


    private final EnterpriseRepository enterpriseRepository;
    public List<Enterprise> getAllEnterprises(){
        return enterpriseRepository.findAll();
    }
    public Enterprise saveDetails(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

}
