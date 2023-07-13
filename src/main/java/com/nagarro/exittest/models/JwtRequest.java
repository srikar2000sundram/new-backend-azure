package com.nagarro.exittest.models;

public class JwtRequest {

    // User name for authentication
    String userName;

    // Password for authentication
    String password;


    /**
     * Default constructor for JwtRequest.
     */
    public JwtRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor for JwtRequest with user name and password.
     * 
     * @param userName the user name
     * @param password the password
     */
    public JwtRequest(String userName, String password) {
        super();
        this.userName = userName; // 2
        this.password = password; // 2
    }

    /**
     * Get the user name.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName; // 3
    }

    /**
     * Set the user name.
     * 
     * @param userName the user name to set
     */
    public void setUserName(String userName) {
        this.userName = userName; // 4
    }

    /**
     * Get the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password; // 5
    }

    /**
     * Set the password.
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password; // 6
    }

}
/**
 * This class represents a JWT authentication request.
 * It contains the user name and password for authentication purposes.
 * 
 * Fields:
 * - userName: The user name for authentication.
 * - password: The password for authentication.
 * 
 * Important methods:
 * 1. JwtRequest():
 *    - Default constructor for JwtRequest.
 * 
 * 2. JwtRequest(String, String):
 *    - Constructor for JwtRequest with user name and password.
 * 
 * 3. getUserName():
 *    - Get the user name.
 * 
 * 4. setUserName(String):
 *    - Set the user name.
 * 
 * 5. getPassword():
 *    - Get the password.
 * 
 * 6. setPassword(String):
 *    - Set the password.
 */
