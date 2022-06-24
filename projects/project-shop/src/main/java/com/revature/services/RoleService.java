package com.revature.services;

import java.util.List;

import com.revature.daos.RoleDAO;
import com.revature.daos.RolePostgres;
import com.revature.models.Role;
import com.revature.models.User;

public class RoleService {
	private RoleDAO rd = new RolePostgres();

	public List<Role> getRoles() {
		return rd.retrieveRole();
	}

}
