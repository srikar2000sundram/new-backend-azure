package com.nagarro.exittest.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exittest.models.User;
import com.nagarro.exittest.models.UserRole;
import com.nagarro.exittest.repository.RoleRepository;
import com.nagarro.exittest.repository.UserRepository;
import com.nagarro.exittest.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository; // Repository for User entity

	@Autowired
	private RoleRepository roleRepository; // Repository for Role entity

	/**
	 * Creates a new user with the provided details and user roles.
	 * 
	 * @param user      The user details.
	 * @param userRoles The set of user roles.
	 * @return The created user.
	 * @throws Exception If the user already exists.
	 */
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.getUserByEmail(user.getEmail()); // Called from UserRepository
		if (local != null) {
			System.out.println("User exists");
			throw new Exception("User already present!");
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole()); // Called from RoleRepository
			}

			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user); // Called from UserRepository
			return local;
		}
	}

	/**
	 * Saves a user in the database.
	 * 
	 * @param user The user to be saved.
	 * @return The saved user.
	 */
	public User save(User user) {
		return this.userRepository.save(user); // Called from UserRepository
	}

	/**
	 * Retrieves a user by their email.
	 * 
	 * @param email The email of the user.
	 * @return The user with the specified email.
	 */
	public User showUser(String email) {
		return this.userRepository.getUserByEmail(email); // Called from UserRepository
	}

	/**
	 * Retrieves a user by their email and password.
	 * 
	 * @param email    The email of the user.
	 * @param password The password of the user.
	 * @return The user with the specified email and password.
	 */
	public User fetchUserByEmailAndPassword(String email, String password) {
		return this.userRepository.findByEmailAndPassword(email, password); // Called from UserRepository
	}

	/**
	 * Retrieves a list of all users.
	 * 
	 * @return A list of all users in the database.
	 */
	public List<User> findAll() {
		return this.userRepository.findAll(); // Called from UserRepository
	}
}

/**
 * This class provides the implementation for the UserService interface.
 * It is responsible for user-related operations such as user creation, retrieval, and saving.
 * 
 * Dependencies:
 * - Requires a UserRepository and RoleRepository for data access.
 * 
 * Important methods:
 * 1. createUser(User user, Set<UserRole> userRoles):
 *    - Creates a new user with the provided details and user roles.
 *    - Throws an exception if the user already exists.
 *    - Returns the created user.
 * 2. save(User user):
 *    - Saves a user in the database.
 *    - Returns the saved user.
 * 3. showUser(String email):
 *    - Retrieves a user by their email.
 *    - Returns the user with the specified email.
 * 4. fetchUserByEmailAndPassword(String email, String password):
 *    - Retrieves a user by their email and password.
 *    - Returns the user with the specified email and password.
 * 5. findAll():
 *    - Retrieves a list of all users.
 *    - Returns a list of all users in the database.
 * 
 * Note: The class utilizes the UserRepository and RoleRepository to interact with the underlying data source.
 */
