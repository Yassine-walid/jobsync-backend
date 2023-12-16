package com.example.backendjobsync.services;

import com.example.backendjobsync.entities.Announcement;

import java.util.List;

public interface AnnouncementService {



    List<Announcement> findAll();
}
