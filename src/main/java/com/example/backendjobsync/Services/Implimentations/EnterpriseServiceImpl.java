package com.example.backendjobsync.Services.Implimentations;

import com.example.backendjobsync.Entities.Enterprise;
import com.example.backendjobsync.Repositories.EnterpriseRepository;
import com.example.backendjobsync.Services.EnterpriseService;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {


    private final EnterpriseRepository enterpriseRepository;
    public List<Enterprise> getAllEnterprises(){
        return enterpriseRepository.findAll();
    }
    public Enterprise saveDetails(Enterprise enterprise) throws Exception {

        // Fill the logoUrl Field
        if (enterprise.getLogoUrl()==null){
            enterprise.setLogoUrl("https://placehold.co/400x400");
        }
        // Check If the date is older than today's date
        if(enterprise.getFoundationDate().after(new Date())){
            throw new Exception("Date Invalid");
        }
        return enterpriseRepository.save(enterprise); }
        public String deleteEnterprise(UUID id) {
             enterpriseRepository.deleteById(id);
             return"enterprise deleted";
        }


}
