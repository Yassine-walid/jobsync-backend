package com.example.backendjobsync.Services;

import com.example.backendjobsync.Entities.Enterprise;


import java.util.List;
import java.util.UUID;


public interface EnterpriseService {

    List<Enterprise> getAllEnterprises();
    Enterprise saveDetails(Enterprise enterprise) throws Exception;
    String deleteEnterprise(UUID id);

}
