package com.example.backendjobsync.services;


import com.example.backendjobsync.entities.Role;
import com.example.backendjobsync.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User findByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username,String roleName);
    List<User> findAllUsers();
}
