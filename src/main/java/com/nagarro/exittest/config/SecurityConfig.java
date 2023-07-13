package com.nagarro.exittest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nagarro.exittest.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTAuthenticationEntryPoint unAuthorizedHandler;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * This bean is responsible for encoding passwords for user authentication.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * This allows the authentication manager to be used in other parts of the application.
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Create and expose the AuthenticationManager as a bean
        return super.authenticationManagerBean();
    }

    /**
     * The passwordEncoder() method defines a bean of type BCryptPasswordEncoder. 
     * This bean is responsible for encoding passwords for user authentication.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure the authentication manager
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    /**
     * class is essential for configuring authentication and authorization mechanisms in your application. 
     * It specifies the rules for protecting resources, handles authentication errors, 
     * and sets up the necessary filters to secure your application's endpoints.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors().disable()
            .authorizeRequests()
                // Allow access to specific endpoints without authentication
                .antMatchers(
                    "/generate-token",                // API for generating a JWT token
                    "/user/register",                 // API for user registration
                    "/home/stats",                    // API for accessing home statistics
                    "/allProducts/**",                // API for accessing all products
                    "/user/**",                       // APIs related to user operations
                    "/admin/**",                      // APIs related to admin operations
                    "/review/request",                // API for submitting a review request
                    "/delete/{productId}",            // API for deleting a product by ID
                    "/getProduct/{productId}")        // API for getting a product by ID
                .permitAll()
                // Allow pre-flight requests (OPTIONS) without authentication
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                // Require authentication for any other request
                .anyRequest().authenticated()
            .and()
                .exceptionHandling().authenticationEntryPoint(unAuthorizedHandler)
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //Spring Security will never create an HttpSession and it will never use it to obtain the SecurityContext

        
        // Add the JWT authentication filter before the UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
