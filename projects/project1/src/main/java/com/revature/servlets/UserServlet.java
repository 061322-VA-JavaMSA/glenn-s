/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;

/**
 *
 */
public class UserServlet extends HttpServlet {
	UserService us = new UserService();
	ObjectMapper om = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String pathInfo = req.getPathInfo();
		if(pathInfo == null) {
//			HttpSession session = req.getSession();
//			System.out.println(session.getAttribute("userRole"));
			List<User> users = us.getUsers(); 
			List<UserDTO> usersDTO = new ArrayList<>();
			
			users.forEach(u -> usersDTO.add(new UserDTO(u)));
	 		PrintWriter pw = resp.getWriter();
			pw.write(om.writeValueAsString(usersDTO));
			pw.close();
			
			
		} else {
			int id = Integer.parseInt(pathInfo.substring(1));
			try (PrintWriter pw = resp.getWriter()){
				User u = us.getUserById(id);
				UserDTO userDTO = new UserDTO(u);
				
				pw.write(om.writeValueAsString(userDTO));
			} catch (UserNotFoundException e) {
				// TODO: handle exception
				resp.setStatus(404);
				e.printStackTrace();
			}
		} 		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
	}

}
