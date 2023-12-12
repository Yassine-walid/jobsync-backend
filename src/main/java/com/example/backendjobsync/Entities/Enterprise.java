package com.example.backendjobsync.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date foundationDate;
    private String address;
    private String email;
    private String logoUrl;
    private Number phoneNumber;
    private String websiteUrl;

    @OneToMany(mappedBy = "id")
    @JsonIgnore
    private List<Announcement> announcements;

}
