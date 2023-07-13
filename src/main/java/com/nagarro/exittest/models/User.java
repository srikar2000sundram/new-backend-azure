package com.nagarro.exittest.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // Unique identifier for the user
	private String email; // Email address of the user
	private String firstName; // First name of the user
	private String lastName; // Last name of the user
	private String password; // Password of the user
	private Boolean enabled = true; // Flag indicating whether the user account is enabled or disabled

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>(); // Set of user roles associated with the user

	public User() {
		// Default constructor
	}

	// Getters and Setters for user fields

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	// UserDetails interface methods

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRole -> {
			set.add(new Authority(userRole.getRole().getRoleName()));
		});
		return set;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}


/**
 * The `User` class represents a user in the system.
 *
 * Fields:
 * - `id`: Unique identifier for the user.
 * - `email`: Email address of the user.
 * - `firstName`: First name of the user.
 * - `lastName`: Last name of the user.
 * - `password`: Password of the user.
 * - `enabled`: Flag indicating whether the user account is enabled or disabled.
 * - `userRoles`: Set of user roles associated with the user.
 *
 * Implements the `UserDetails` interface required for user authentication and authorization.
 *
 * Methods:
 * - `getAuthorities()`: Returns a collection of granted authorities (user roles) for the user.
 * - `getUsername()`: Returns the username of the user, which is the email address.
 * - `isAccountNonExpired()`: Indicates whether the user account is not expired.
 * - `isAccountNonLocked()`: Indicates whether the user account is not locked.
 * - `isCredentialsNonExpired()`: Indicates whether the user credentials are not expired.
 * - `isEnabled()`: Indicates whether the user account is enabled.
 */