package com.example.backendjobsync.Services;

import com.example.backendjobsync.Entities.Announcement;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AnnouncementService {

    ResponseEntity<List<Announcement>> getAllAnnouncement();

    ResponseEntity<Announcement> saveAnnouncement(Announcement announcement);

    ResponseEntity<?> getAnnouncementById(Long id);

    ResponseEntity<?> getAnnouncementByDomain(String domain);
    ResponseEntity<?> updateAnnouncement(Announcement newDataAnnouncement,Long id);

    ResponseEntity<?> deleteAnnouncement(Long id);
}
