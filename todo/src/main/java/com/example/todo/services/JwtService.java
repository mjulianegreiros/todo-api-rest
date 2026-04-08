package com.example.todo.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.example.todo.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService{
    private static final String SECRET = "801846d8c8529bbb192e90f4fb4a58b3096de5de41ee6bd355e52fe2638f2571";
    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
    }
    public String generateToken(User user){
        return Jwts.builder().subject(user.getEmail()).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 86400000)).signWith(getSecretKey()).compact();
    }
    public String extractEmail(String token){
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }
}