package com.example.backendjobsync.controllers;

import com.example.backendjobsync.entities.Announcement;
import com.example.backendjobsync.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/announcement")
@CrossOrigin(origins = "*")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService)
    {
        this.announcementService = announcementService;
    }

    @GetMapping("/all")
    public List<Announcement> getAllAnnouncements(){
        return announcementService.findAll();
    }


}
