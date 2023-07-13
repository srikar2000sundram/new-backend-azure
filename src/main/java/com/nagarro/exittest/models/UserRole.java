package com.nagarro.exittest.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId; // Unique identifier for the user role
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user; // Associated user
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role; // Associated role

	public UserRole() {
		super();
		// Default constructor
	}

	// Getters and Setters for UserRole fields

	/**
	 * Get the associated User.
	 * 
	 * @return the associated User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the associated User.
	 * 
	 * @param user the User to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Get the associated Role.
	 * 
	 * @return the associated Role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Set the associated Role.
	 * 
	 * @param role the Role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Get the user role ID.
	 * 
	 * @return the user role ID
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}
}


/**
 * The `UserRole` class represents the association between a user and a role.
 *
 * Fields:
 * - `userRoleId`: Unique identifier for the user role.
 * - `user`: Associated user.
 * - `role`: Associated role.
 *
 * This class is annotated with `@Entity` to indicate that it is a JPA entity and can be persisted to a database.
 *
 * The `userRoleId` field is annotated with `@Id` and `@GeneratedValue` to specify it as the primary key and to generate its value automatically.
 *
 * The `user` field is annotated with `@ManyToOne` to establish a many-to-one relationship with the `User` entity. It fetches the associated user eagerly.
 *
 * The `role` field is annotated with `@ManyToOne` to establish a many-to-one relationship with the `Role` entity. It fetches the associated role eagerly.
 *
 * Provides methods to get and set the associated user and role, as well as retrieving the user role ID.
 */
