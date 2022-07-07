package com.revature.dto;

import java.sql.Timestamp;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;

public class ReimbursementDTO {


	private int id;
	
	private double amount;
	
	private String  submitted;
	
 	private String  resolved;
	
	private String receipt;

	private UserDTO author;
	
	private UserDTO resolver;	

	private ReimbursementStatus  reim_status;
	
	private ReimbursementType  reim_type;

	public ReimbursementDTO(Reimbursement r) {
 		// TODO Auto-generated constructor stub
		id = r.getId();
		
		amount = r.getAmount();
		
		submitted = r.getSubmitted().toString();
		
	 	resolved = (r.getResolved() == null) ? "":r.getResolved() .toString();
		
		receipt = r.getReceipt();

		author = new UserDTO(r.getAuthor());
		
		resolver = new UserDTO(r.getResolver());	

		reim_status = r.getReim_status();
		
		reim_type = r.getReim_type();
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}

	public UserDTO getResolver() {
		return resolver;
	}

	public void setResolver(UserDTO resolver) {
		this.resolver = resolver;
	}

	public ReimbursementStatus getreim_status() {
		return reim_status;
	}

	public void setreim_status(ReimbursementStatus reim_status) {
		this.reim_status = reim_status;
	}

	public ReimbursementType getReim_type() {
		return reim_type;
	}

	public void setReim_type(ReimbursementType reim_type) {
		this.reim_type = reim_type;
	}
}
