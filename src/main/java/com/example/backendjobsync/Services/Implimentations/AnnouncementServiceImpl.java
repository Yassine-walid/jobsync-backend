package com.example.backendjobsync.Services.Implimentations;

import com.example.backendjobsync.Entities.Announcement;

import com.example.backendjobsync.Repositories.AnnouncementRepository;
import com.example.backendjobsync.Services.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private final AnnouncementRepository announcementRepository;

    @Override
    public ResponseEntity<List<Announcement>> getAllAnnouncement(){
        return ResponseEntity.ok().body(announcementRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getAnnouncementById(Long id){
        Optional<Announcement> announcement = announcementRepository.findById(id);
        if(announcement.isPresent()){
            return new ResponseEntity<>(announcement,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("Announcement Not Fount",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getAnnouncementByDomain(String domain){
        List<Announcement> announcements = announcementRepository.findByDomain(domain);

        if (!announcements.isEmpty()) {
            return ResponseEntity.ok(announcements);
        } else {
            return new ResponseEntity<>("No announcements found for the domain: " + domain,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Announcement> saveAnnouncement(Announcement announcement){

        if(announcement.getBannerUrl() == null){
            announcement.setBannerUrl("https://placehold.co/600x400");
        }

        announcement.setPuclicationDate(new Date());

        announcementRepository.save(announcement);

        return new ResponseEntity<>(announcement, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<?> updateAnnouncement(Announcement newDataAnnouncement,Long id){
        Optional<Announcement> announcement = announcementRepository.findById(id);

        if(announcement.isPresent()){

            Announcement announcementUpdate = announcement.get();
            announcementUpdate.setTitle(newDataAnnouncement.getTitle()); ;
            announcementUpdate.setDescription(newDataAnnouncement.getDescription()); ;
            announcementUpdate.setBannerUrl(newDataAnnouncement.getBannerUrl());
            announcementUpdate.setDomain(newDataAnnouncement.getDomain());
            announcementUpdate.setDegree(newDataAnnouncement.getDegree());
            announcementUpdate.setYearsExp(newDataAnnouncement.getYearsExp());

            announcementRepository.save(announcementUpdate);
            return new ResponseEntity<>(announcementUpdate,HttpStatus.ACCEPTED);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Announcement Not modified");
        }
    }

    @Override
    public ResponseEntity<?> deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
        return new ResponseEntity<>("Announcement deleted",HttpStatus.ACCEPTED);
    }
}
