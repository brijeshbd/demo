package com.auth.brijesh.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    public String getUserNameFromToken(String token);
    String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
