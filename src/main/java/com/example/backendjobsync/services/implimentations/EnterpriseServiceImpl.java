package com.example.backendjobsync.services.implimentations;

import com.example.backendjobsync.entities.Enterprise;
import com.example.backendjobsync.repositories.EnterpriseRepository;
import com.example.backendjobsync.services.EnterpriseService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {


    private final EnterpriseRepository enterpriseRepository;

    @Override
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
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public ResponseEntity<Optional<Enterprise>> getEnterpriseById(Long id) {
        return ResponseEntity.ok().body(enterpriseRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> updateEnterprise(Enterprise newDataEnterprise, Long id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);

        if(enterprise.isPresent()){
            Enterprise enterpriseUpdate = enterprise.get();
            if(newDataEnterprise.getName()!=null)enterpriseUpdate.setName(newDataEnterprise.getName());
            if(newDataEnterprise.getAddress()!=null)enterpriseUpdate.setAddress(newDataEnterprise.getAddress());
            if(newDataEnterprise.getDescription()!=null)enterpriseUpdate.setDescription(newDataEnterprise.getDescription());
            if(newDataEnterprise.getFoundationDate()!=null)enterpriseUpdate.setFoundationDate(newDataEnterprise.getFoundationDate());
            if(newDataEnterprise.getLogoUrl()!=null)enterpriseUpdate.setLogoUrl(newDataEnterprise.getLogoUrl());
            if(newDataEnterprise.getWebsiteUrl()!=null)enterpriseUpdate.setWebsiteUrl(newDataEnterprise.getWebsiteUrl());
            if(newDataEnterprise.getPhoneNumber()!=null)enterpriseUpdate.setPhoneNumber(newDataEnterprise.getPhoneNumber());
            enterpriseRepository.save(enterpriseUpdate);
            return new ResponseEntity<>(enterpriseUpdate,HttpStatus.ACCEPTED);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Enterprise Not modified");
        }
    }


    @Override
    public ResponseEntity<String> deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
        return ResponseEntity.ok().body("enterprise deleted");
    }
}
