package org.example.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Util class to proceed with JWT.
 */
@Service
public class JwtUtil {
    @Value("${authentication.tokenSecret}")
    private String tokenSecret;

    @Value("${authentication.tokenExpirationMsec}")
    private Long tokenExpirationMsec;

    /**
     * Generates new JWT token.
     *
     * @param extraClaims - map, containing claims to add.
     * @param userDetails - userDetails, which should be included in the JWT claims.
     * @return generated JWT token string
     */
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        Date now = new Date();
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(now)
                .expiration(new Date(now.getTime() + tokenExpirationMsec))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Checks, if the token is valid.
     *
     * @param token - JWT token string
     * @param userDetails - userDetails, to take information from.
     * @return
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Method to extract username from token
     *
     * @param token - JWT token string
     * @return extracted username
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Method to extract claim from token.
     *
     * @param token - JWT token string
     * @param claimsResolver - function to retrieve claim
     * @return extracted claim
     * @param <T>
     */
    private  <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Checks, whether the token is expired.
     *
     * @param token - JWT token string
     * @return {@code  TRUE} if token is expired, {@code FALSE} otherwise
     */
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    /**
     * Method to extract claims from token.
     *
     * @param token- JWT token string
     * @return {@link Claims}
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Method to generate secret key.
     *
     * @return {@link Key}
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(tokenSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
