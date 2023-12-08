package com.example.backendjobsync.Controllers;

import com.example.backendjobsync.Entities.Announcement;
import com.example.backendjobsync.Entities.Enterprise;
import com.example.backendjobsync.Services.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/announcement")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAnnouncements(){
        return new ResponseEntity<>(announcementService.getAllAnnouncement(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnnouncementById(@PathVariable("id")Long id){
        Optional<?> announcement = Optional.ofNullable(announcementService.getAnnouncementById(id));

        if(announcement.isPresent()){
            return new ResponseEntity<>(announcement, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Not Found", HttpStatus.OK);
        }

    }

    @GetMapping("/domain/{domain}")
    public ResponseEntity<?> getAnnouncementByDomain(@PathVariable("domain")String domain){
        Optional<?> announcements = Optional.ofNullable(announcementService.getAnnouncementByDomain(domain));

        if(announcements.isPresent()){
            return new ResponseEntity<>(announcements, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<?> addAnnouncement(@RequestBody Announcement announcement) throws Exception{
        return new ResponseEntity<>(announcementService.saveAnnouncement(announcement),HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateEnterprise(@PathVariable("id") Long id, @RequestBody Announcement announcement) throws Exception{
        return new ResponseEntity<>(announcementService.updateAnnouncement(announcement,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable("id") Long id){
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.ok().body("Enterprise Deleted");
    }
}
