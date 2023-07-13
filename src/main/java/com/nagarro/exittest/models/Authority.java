package com.nagarro.exittest.models;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class Authority implements GrantedAuthority {

	private String authority;

	

	/**
	 * Constructs an Authority object with the specified authority name.
	 * 
	 * @param authority The name of the authority.
	 */
	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	/**
	 * Returns the name of the authority.
	 * 
	 * @return The name of the authority.
	 */
	@Override
	public String getAuthority() {
		return this.authority; // 1
	}
}
/**
 * This class represents an authority granted to a user.
 * It implements the GrantedAuthority interface provided by Spring Security.
 * 
 * Fields:
 * - authority: The name of the authority.
 * 
 * Important methods:
 * 1. getAuthority():
 *    - Returns the name of the authority.
 */