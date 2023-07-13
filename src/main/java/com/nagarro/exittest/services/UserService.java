package com.nagarro.exittest.services;

import java.util.List;
import java.util.Set;

import com.nagarro.exittest.models.User;
import com.nagarro.exittest.models.UserRole;

public interface UserService {

    // 1. This interface defines the contract for the UserService

    /**
     * Creates a new user with the given details and associated roles.
     *
     * @param user      The user to be created.
     * @param userRoles The set of roles associated with the user.
     * @return The created user.
     * @throws Exception If an exception occurs during user creation.
     */
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    /**
     * Saves a user in the database.
     *
     * @param user The user to be saved.
     * @return The saved user.
     */
    public User save(User user);

    /**
     * Retrieves a user by their email.
     *
     * @param email The email of the user.
     * @return The user with the specified email.
     */
    public User showUser(String email);

    /**
     * Retrieves a user by their email and password.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return The user with the specified email and password.
     */
    public User fetchUserByEmailAndPassword(String email, String password);

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    public List<User> findAll();
}
