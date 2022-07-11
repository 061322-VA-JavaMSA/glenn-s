package com.revature.services;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class AuthService {

	private UserDAO ud = new UserHibernate();
	private ObjectMapper om = new ObjectMapper();

	/*-
	 * if the user is found by username and the password matches, returns that user
	 */
	public User login(String username, String password) throws UserNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		User principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}
	

}
