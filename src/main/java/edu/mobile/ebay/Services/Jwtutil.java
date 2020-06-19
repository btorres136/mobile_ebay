package edu.mobile.ebay.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Jwtutil
 */
@Service
public class Jwtutil {

    private String SECRET_KEY = "!#@pO09iK%E5@;&*<SdUBzYjg2OTQyYjAzMmIiLC+=>=+JleHAiOjE1NDY2OD*!+_g3MzAsImF1dGhv<=cml0aWVzIjpb>=IlNUQ_+=U5EQVJEX%^&#$1VTRVI'//}{~`~`@13iLCJBRE1JTl9VU0VSIl0sImp0#$%)(SI6IjUyMjQ3NTFkLT-+)k0Yz";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims =  new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 )).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}