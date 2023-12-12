package com.example.backendjobsync.Services;

import com.example.backendjobsync.Entities.Role;
import com.example.backendjobsync.Entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUsername (String username);

    Role addRole(Role role);
    User addRoleToUser(String username, String roleName);
    List<User> findAllUsers();
}
