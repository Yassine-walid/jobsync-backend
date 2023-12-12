package com.example.backendjobsync.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String bannerUrl;
    private String domain;
    private String degree;
    private Number yearsExp;
    private Date puclicationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enterprise_id",nullable = false)
    private Enterprise enterprise;




}





