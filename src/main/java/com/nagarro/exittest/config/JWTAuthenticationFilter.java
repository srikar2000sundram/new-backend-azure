package com.nagarro.exittest.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nagarro.exittest.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;




@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsServiceImpl detailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * This method intercepts incoming requests and processes the JWT token present in the request header.
     * 
     * It extracts the token, validates it, and sets the authenticated user in the security context 
     * if the token is valid.
     * 
     * The filter is executed once per request due to extending the OncePerRequestFilter class.
     * 
     * Called by: Spring Security framework when an incoming request is received.
     * 
     */
    @Override
    // doFilterInternal method is overridden method from OncePerRequestFilter
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Retrieve the JWT token from the request header
        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println(requestTokenHeader);

        String username = null;
        String jwtToken = null;

        // Check if the token is present and starts with "Bearer "
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7); // Removing "Bearer " prefix
            System.out.println(jwtToken);

            try {
                // Extract the username from the JWT token
                username = this.jwtUtils.extractEmail(jwtToken); // Called from JwtUtils class
                System.out.println(username);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.out.println("JWT Token expired");
            }
        } else {
            System.out.println("Invalid Token, does not start with Bearer");
        }

        // Validate security
        // if a username is provided (not null) and there is no authenticated user
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Load user details by username
            final UserDetails userDetails = this.detailsServiceImpl.loadUserByUsername(username);
            
            if (this.jwtUtils.validateToken(jwtToken, userDetails)) { // Validate the JWT token
                // Token is valid

                // Create an instance of UsernamePasswordAuthenticationToken with the user details,
                // null credentials, and authorities
                UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                // Set the request details for authentication
                usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
            }
        } else {
            System.out.println("Token is not valid");
        }

        // Continue the filter chain
        filterChain.doFilter(request, response); // Calls the next filter in the chain
    }

}
/**

This filter is responsible for intercepting incoming requests and processing, 
the JWT token present in the request header.

It extracts the token, validates it, 
and sets the authenticated user in the security context if the token is valid.

The filter is executed once per request due to extending the OncePerRequestFilter class.

The UserDetailsServiceImpl is used to load user details based on the extracted username from the JWT token.

The JwtUtils class is used to validate the token and extract information from it.

The filter chain is then continued to allow further processing of the request.

 */
