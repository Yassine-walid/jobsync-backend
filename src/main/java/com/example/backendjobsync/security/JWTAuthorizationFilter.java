package com.example.backendjobsync.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");
        if(jwt==null || !jwt.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        jwt = jwt.substring(7);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.SECURITY)).build();
        DecodedJWT decodedJWT = verifier.verify(jwt);
        String username = decodedJWT.getSubject();
        List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String role:roles)
            authorities.add(new SimpleGrantedAuthority(role));
        UsernamePasswordAuthenticationToken user =new UsernamePasswordAuthenticationToken(
                username,null,authorities
        );

        SecurityContextHolder.getContext().setAuthentication(user);
        filterChain.doFilter(request,response);
    }
}
