package org.example.spring.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtill {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.ES256); // 256 algoritmi
    private static final long EXPIRATION_TIME = 364_000_000; // tokenin bitme vaxti

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Tokenə "mövzu" (subject) olaraq istifadəçi adını yazır. Yəni token kimə aiddir.
                .setIssuedAt(new Date(System.currentTimeMillis())) // Tokenin yaradılma vaxtını təyin edir.
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Tokenin bitmə tarixini göstərir (indiki vaxta EXPIRATION_TIME əlavə edir).
                .signWith(key) // Tokeni gizli açarla imzalayır ki, sonradan dəyişdirilibsə yoxlamaq mümkün olsun.
                .compact(); // 	Bütün bu məlumatları JWT formatında birləşdirir və String formatında nəticəni qaytarır.

    }

    public static String validateTokenAndGetUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token).getBody().getSubject();
    }
}
