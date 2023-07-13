package com.nagarro.exittest.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	private Long roleId; // 1. Unique identifier for the role

	private String roleName; // 2. Name of the role

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<UserRole> userRoles = new HashSet<>(); // 3. Set of user roles associated with this role

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Getters and setters for the role fields

	/**
	 * Get the name of the role.
	 * 
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName; // 5
	}

	/**
	 * Set the name of the role.
	 * 
	 * @param roleName the role name to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName; // 6
	}

	/**
	 * Get the unique identifier of the role.
	 * 
	 * @return the role ID
	 */
	public Long getRoleId() {
		return roleId; // 7
	}

	/**
	 * Get the set of user roles associated with this role.
	 * 
	 * @return the set of user roles
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles; // 9
	}

	/**
	 * Set the set of user roles associated with this role.
	 * 
	 * @param userRoles the set of user roles to set
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles; // 10
	}

	/**
	 * Set the unique identifier of the role.
	 * 
	 * @param roleId the role ID to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId; // 8
	}
}
