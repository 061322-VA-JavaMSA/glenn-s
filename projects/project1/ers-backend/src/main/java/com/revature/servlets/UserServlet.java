/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ProfileDTO;
import com.revature.dto.ReimbursementDTO;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UserNotUpdatedException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

/**
 *
 */
public class UserServlet extends HttpServlet {
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		super.doOptions(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

	}

	UserService us = new UserService();
	ObjectMapper om = new ObjectMapper();
	ReimbursementService rs = new ReimbursementService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		String pathInfo = req.getPathInfo();

		if(pathInfo == null) {
//			HttpSession session = req.getSession();
//			System.out.println(session.getAttribute("userRole"));
			List<User> users = us.getUsers(); 
			List<ProfileDTO> profileDTO = new ArrayList<>();
//			
			users.forEach(u -> profileDTO.add(new ProfileDTO(u)));
	 		PrintWriter pw = resp.getWriter();
			pw.write(om.writeValueAsString(profileDTO));
			pw.close();
			
			
		} else {
//			
	        String regex = "[0-9]/[\breim]";

 	         Pattern pattern = Pattern.compile(regex);
	         Matcher matcher = pattern.matcher(pathInfo);
 	         if(matcher.find()) {
	        	 String[] pathParts = pathInfo.split("/");
	        	 
	 			int id = Integer.parseInt(pathParts[1]);
 
 				try (PrintWriter pw = resp.getWriter()){
					User u = us.getUserById(id);
 					List<Reimbursement> reimburse = rs.getByAuthor(u);
					List<ReimbursementDTO> reimDTO = new ArrayList<>();
					reimburse.forEach(r -> reimDTO.add(new ReimbursementDTO(r)));
 					pw.write(om.writeValueAsString(reimDTO));
					pw.close();
					resp.setStatus(200);

				} catch (ReimbursementNotFoundException | UserNotFoundException e) {
					// TODO: handle exception
					resp.setStatus(404);
					e.printStackTrace();
				}
	         } else {
	 				int id = Integer.parseInt(pathInfo.substring(1));
					try (PrintWriter pw = resp.getWriter()){
						User u = us.getUserById(id);
						ProfileDTO profileDTO = new ProfileDTO(u);
						resp.setStatus(200);

						pw.write(om.writeValueAsString(profileDTO));
					} catch (UserNotFoundException e) {
						// TODO: handle exception
						resp.setStatus(404);
						e.printStackTrace();
					}	
	         }        
			
 			

		} 		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		 
 		InputStream reqBody = req.getInputStream();

		String pathInfo = req.getPathInfo();
//
 			int id = Integer.parseInt(pathInfo.substring(1));
	        
			User u = om.readValue(reqBody, User.class);
			u.setId(id);
//          working  			
//			HttpSession session = req.getSession();
//			System.out.println(session.getAttribute("userName"));
			try {
				boolean bool = us.updatetUser(u);
				try(PrintWriter pw = resp.getWriter()){
					pw.write(om.writeValueAsString(u));
					resp.setStatus(200);
				}				
			} catch (UserNotUpdatedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
	}

}
