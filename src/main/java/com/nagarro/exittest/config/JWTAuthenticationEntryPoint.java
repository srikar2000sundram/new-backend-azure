package com.nagarro.exittest.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * This method is called when a user tries to access a protected resource without proper authentication.
 * It handles the entry point for authentication.
 * It receives the HttpServletRequest, HttpServletResponse, and AuthenticationException as parameters.
 * The method throws IOException and ServletException.
 */
@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {


    /**
     * This class serves as the entry point for authentication 
     * when a user tries to access a protected resource without proper authentication.
     * 
     * It is responsible for sending an HTTP error response with the appropriate status code and message.
     * In this case, it sends a 401 (Unauthorized) status code along with the message "Unauthorized: Server".
     * 
     * The @Component annotation marks this class as a Spring component, allowing it to 
     * be automatically detected and instantiated by the Spring framework during application startup.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        // Send an HTTP error response with the status code 401 (Unauthorized) and a message.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Server");

    }

}
