package com.example.backendjobsync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String postTitle;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String email;
    private Number phoneNumber;
    @Column(unique = true)
    private String username;
    private String password;
    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles;

}
