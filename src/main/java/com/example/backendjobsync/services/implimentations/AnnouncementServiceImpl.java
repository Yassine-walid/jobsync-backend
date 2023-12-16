package com.example.backendjobsync.services.implimentations;

import com.example.backendjobsync.entities.Announcement;
import com.example.backendjobsync.repositories.AnnouncementRepository;
import com.example.backendjobsync.services.AnnouncementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }



}
