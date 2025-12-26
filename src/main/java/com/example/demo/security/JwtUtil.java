package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    
    public String generateToken(Long userId, String email, String role) {
        return "jwt_token_" + userId + "_" + email + "_" + role;
    }
    
    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt_token_");
    }
    
    public String extractEmail(String token) {
        String[] parts = token.split("_");
        return parts.length > 3 ? parts[3] : null;
    }
}