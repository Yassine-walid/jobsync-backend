package com.example.backendjobsync.services.implimentations;

import com.example.backendjobsync.entities.Role;
import com.example.backendjobsync.entities.User;
import com.example.backendjobsync.repositories.RoleRepository;
import com.example.backendjobsync.repositories.UserRepository;
import com.example.backendjobsync.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRole(roleName);

        user.getRoles().add(role);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
