package com.nagarro.exittest.models;

public class JwtResponse {
	
	// JWT token
	String token;

	
	/**
	 * Default constructor for JwtResponse.
	 */
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for JwtResponse with token.
	 * 
	 * @param token the JWT token
	 */
	public JwtResponse(String token) {
		super();
		this.token = token; // 2
	}

	/**
	 * Get the JWT token.
	 * 
	 * @return the JWT token
	 */
	public String getToken() {
		return token; // 3
	}

	/**
	 * Set the JWT token.
	 * 
	 * @param token the JWT token to set
	 */
	public void setToken(String token) {
		this.token = token; // 4
	}
}
/**
 * This class represents a JWT authentication response.
 * It contains the JWT token generated after successful authentication.
 * 
 * Fields:
 * - token: The JWT token.
 * 
 * Important methods:
 * 1. JwtResponse():
 *    - Default constructor for JwtResponse.
 * 
 * 2. JwtResponse(String):
 *    - Constructor for JwtResponse with token.
 * 
 * 3. getToken():
 *    - Get the JWT token.
 * 
 * 4. setToken(String):
 *    - Set the JWT token.
 */
