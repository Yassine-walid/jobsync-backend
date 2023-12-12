package com.example.backendjobsync.Security;

import com.example.backendjobsync.Entities.User;
import com.example.backendjobsync.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User Not Found");
        else {
            List<GrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
                authorities.add(authority);
            });
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    authorities
            );
        }

    }
}