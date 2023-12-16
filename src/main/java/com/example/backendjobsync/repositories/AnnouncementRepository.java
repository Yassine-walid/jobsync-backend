package com.example.backendjobsync.repositories;

import com.example.backendjobsync.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
//    @Query("select a from Announcement a ")
//    List<Announcement> findByEnterprise();
}
