package com.virasat.user_service.utils;

import java.util.Date;
import io.jsonwebtoken.*;
import java.util.Map;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virasat.user_service.models.JWTDescription;

@Component
public class JWTUtils {
    @Value("${jwt.secret.key}")
    private String JWTSecretKey;

    public JWTUtils() {
        System.out.println(JWTSecretKey + "GHello");
    }

    public String generateToken(JWTDescription description, String issuer) {
        Map<String, Object> claimsMap = claimBuilder(description);
        Key key = new SecretKeySpec(Base64.getDecoder().decode(JWTSecretKey), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .addClaims(claimsMap)
                .setIssuer(issuer)
                .setIssuedAt(new Date())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public void validateToken(JWTDescription description, String issuer, String token) {
        Map<String, Object> claimsMap = claimBuilder(description);
        Key key = StringToKeyConverter(JWTSecretKey);
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token).getBody();
        System.out.println("helloadfasdf");
        System.out.println(claims);

    }

    private Map<String, Object> claimBuilder(Object description) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(description, Map.class);
    }

    private Key StringToKeyConverter(String key) {
        return new SecretKeySpec(Base64.getDecoder().decode(key), SignatureAlgorithm.HS256.getJcaName());
    }
}