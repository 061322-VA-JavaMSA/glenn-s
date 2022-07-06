package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class ReimbursementServlet extends HttpServlet {
	ReimbursementService rs = new ReimbursementService();
	UserService us = new UserService();
	
	ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String pathInfo = req.getPathInfo();
 		if(pathInfo == null) {
 
			List<Reimbursement> reimburse = rs.getReimburse(); 
 			
 	 		PrintWriter pw = resp.getWriter();
			pw.write(om.writeValueAsString(reimburse));
			pw.close();
			
			
		} else {
			//this is just a test 
			int id = Integer.parseInt(pathInfo.substring(1));
			try (PrintWriter pw = resp.getWriter()){
				User u = us.getUserById(id);
				List<Reimbursement> reimburse = rs.getByAuthor(u);
				System.out.println(reimburse); 
		//				ReimbursementDTO userDTO = new ReimbursementDTO(u);
				pw.write(om.writeValueAsString(reimburse));
//				pw.write(om.writeValueAsString(userDTO));
			} catch (ReimbursementNotFoundException | UserNotFoundException e) {
				// TODO: handle exception
				resp.setStatus(404);
				e.printStackTrace();
			}
			
		} 		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
