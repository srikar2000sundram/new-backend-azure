package com.nagarro.exittest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.exittest.models.User;
import com.nagarro.exittest.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * Loads a user by their username (email) from the database.
	 * 
	 * @param username The username (email) of the user.
	 * @return A UserDetails object representing the user.
	 * @throws UsernameNotFoundException If no user is found with the given username.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.getUserByEmail(username); // Call to UserRepository to fetch user by email
		if (user == null) {
			throw new UsernameNotFoundException("No User Found");
		}
		return user; // User object is returned as UserDetails
	}
}
/**
 * This class provides the implementation for the UserDetailsService interface.
 * It is responsible for loading a user from the database based on their username (email).
 * 
 * Dependencies:
 * - Requires a UserRepository for data access.
 * 
 * Important method:
 * 1. loadUserByUsername(String username):
 *    - Loads a user by their username (email) from the database.
 *    - Throws a UsernameNotFoundException if no user is found.
 *    - Returns a UserDetails object representing the user.
 * 
 * Note: The class utilizes the UserRepository to interact with the underlying data source.
 */