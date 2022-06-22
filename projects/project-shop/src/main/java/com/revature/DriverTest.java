package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.RoleService;
import com.revature.services.UserService;

public class DriverTest {
	static UserService us;
	static RoleService rs;

	public static void main(String[] args) {
//		us = new UserService();
//		List<User> users = us.getUsers();
//		for(User u : users) {
//			System.out.println(u);
//		}	
		rs = new RoleService();
		List<Role> roles = rs.getRoles();
		for(Role r : roles) {
			System.out.println(r);
		}			
	}
	
 
}
