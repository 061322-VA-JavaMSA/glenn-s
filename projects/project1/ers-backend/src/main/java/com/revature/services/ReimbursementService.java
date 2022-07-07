package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementService {
	private ReimbursementDAO rd = new ReimbursementHibernate();
	
	
	public List<Reimbursement> getReimburse() {
		List<Reimbursement> reimburse = rd.getReimbursements();
		return reimburse;
	}
	
	public List<Reimbursement>  getByAuthor(User u) throws ReimbursementNotFoundException {
		List<Reimbursement> reimburse = rd.getByAuthor(u);
		return reimburse;
	}
}
