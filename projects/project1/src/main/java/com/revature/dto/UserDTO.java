/**
 * 
 */
package com.revature.dto;

import com.revature.models.Role;
import com.revature.models.User;

/**
 *
 */
public class UserDTO {
	private int id;
	private String username;
	private Role role;

	public UserDTO(User u) {
		id = u.getId();
		username = u.getUsername();
		role = u.getRole();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
