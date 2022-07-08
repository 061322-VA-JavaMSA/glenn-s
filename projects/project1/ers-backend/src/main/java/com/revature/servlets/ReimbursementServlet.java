package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ReqReimbursementDTO;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.ReimbursementStatusNotFoundException;
import com.revature.exceptions.ReimbursementTypeNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.ReimbursementStatusService;
import com.revature.services.ReimbursementTypeService;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	ReimbursementService rs = new ReimbursementService();
	ReimbursementStatusService rss = new ReimbursementStatusService();
	ReimbursementTypeService rt = new ReimbursementTypeService();
	UserService us = new UserService();

	ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String pathInfo = req.getPathInfo();
		if (pathInfo == null) {

			List<Reimbursement> reimburse = rs.getReimburse();

			PrintWriter pw = resp.getWriter();
			pw.write(om.writeValueAsString(reimburse));
			pw.close();

		} else {
			// this is just a test
			int id = Integer.parseInt(pathInfo.substring(1));
			try (PrintWriter pw = resp.getWriter()) {
				User u = us.getUserById(id);
				List<Reimbursement> reimburse = rs.getByAuthor(u);
				System.out.println(reimburse);
				// ReimbursementDTO userDTO = new ReimbursementDTO(u);
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
//		super.doPost(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		InputStream reqBody = req.getInputStream();
         
		ReqReimbursementDTO newReimbursementDTO = om.readValue(reqBody, ReqReimbursementDTO.class);
		System.out.println(newReimbursementDTO.toString());
		Reimbursement newReimbursement = new Reimbursement();
 		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());

 
 		try {
			newReimbursement.setAmount(newReimbursementDTO.getAmount());
			newReimbursement.setDescription(newReimbursementDTO.getDescription());
			newReimbursement.setAuthor(us.getUserById(newReimbursementDTO.getAuthor_id()));
			newReimbursement.setReim_status(rss.getReimbursementStatusById(1));
			newReimbursement.setReim_type(rt.getReimbursementTypeById(newReimbursementDTO.getReimb_type_id()));
			newReimbursement.setSubmitted(timestamp1);
			Reimbursement newR =  rs.insertReimbursement(newReimbursement);
			try(PrintWriter pw = resp.getWriter()){
				pw.write(om.writeValueAsString(newR));
				resp.setStatus(200);
			}
		} catch (ReimbursementNotCreatedException | UserNotFoundException | ReimbursementStatusNotFoundException | ReimbursementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			resp.setStatus(404);
			e.printStackTrace();
		}
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
