package com.nagarro.exittest.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// This class provides utility methods for working with JWT tokens.

@Component
public class JwtUtils {

    private String SECRET_KEY = "nagarroTest";

    /**
     * Extracts the email from the JWT token.
     *
     * @param token The JWT token.
     * @return The email extracted from the token.
     */
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the expiration date from the JWT token.
     *
     * @param token The JWT token.
     * @return The expiration date of the token.
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts a specific claim from the JWT token.
     *
     * @param token          The JWT token.
     * @param claimsResolver The function to resolve the desired claim.
     * @return The value of the resolved claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extracts all claims from the JWT token.
     *
     * @param token The JWT token.
     * @return All claims extracted from the token.
     */
    private Claims extractAllClaims(String token) {
        // JWT token is being parsed and the claims are extracted using the provided SECRET_KEY.
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
   
    /**
     * Checks if the JWT token is expired.
     *
     * @param token The JWT token.
     * @return True if the token is expired, false otherwise.
     */
    private Boolean isTokenExpired(String token) {
        // The expiration date is extracted from the token, and 
    	// it is checked if it is before the current date.
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generates a JWT token for the provided user details.
     *
     * @param userDetails The user details.
     * @return The generated JWT token.
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // A JWT token is generated with the specified claims and 
        // the subject (username) taken from the user details.
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * Creates a JWT token with the specified claims and subject.
     *
     * @param claims  The claims to be included in the token.
     * @param subject The subject (username) of the token.
     * @return The created JWT token.
     */
    private String createToken(Map<String, Object> claims, String subject) {
        // A JWT token is created with the specified claims, subject, issued date, expiration date, 
    	// and signed using the provided SECRET_KEY.
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    /**
     * Validates the JWT token.
     *
     * @param token        The JWT token.
     * @param userDetails The user details.
     * @return True if the token is valid, false otherwise.
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractEmail(token);
        // The email is extracted from the token, and it is checked 
        //if it matches the username from the user details.
        // Additionally, it is checked if the token is not expired.
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

/**
2. It allows extracting claims, generating tokens, and validating tokens.
3. The `extractEmail` method extracts the email from the JWT token.
4. The `extractExpiration` method extracts the expiration date from the JWT token.
5. The `extractClaim` method extracts a specific claim from the JWT token using a provided claims resolver.
6. The `extractAllClaims` method extracts all claims from the JWT token.
7. The `isTokenExpired` method checks if the JWT token is expired.
8. The `generateToken` method generates a JWT token for the provided user details.
9. The `createToken` method creates a JWT token with the specified claims and subject.
10. The `validateToken` method validates the JWT token by comparing the extracted email 
 with the username in the user details and checking if the token is expired.

11. It can be injected into other Spring components and used for JWT-related operations.
*/
