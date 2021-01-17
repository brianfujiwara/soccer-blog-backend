package com.firsttouch.soccerblogbackend.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtCreator {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String getUsernameFromToken( String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }


    public String generateToken(Authentication authentication){

        MyUserDetails myUser = (MyUserDetails) authentication.getPrincipal();

        Date now = new Date();
        Date expireDay = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(myUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireDay)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                //.signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e){


        }

        return false;
    }
}
