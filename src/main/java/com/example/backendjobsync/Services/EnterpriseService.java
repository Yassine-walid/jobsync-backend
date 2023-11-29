package com.example.backendjobsync.Services;

import com.example.backendjobsync.Entities.Enterprise;


import java.util.List;


public interface EnterpriseService {

    List<Enterprise> getAllEnterprises();
    Enterprise saveDetails(Enterprise enterprise) throws Exception;

}
