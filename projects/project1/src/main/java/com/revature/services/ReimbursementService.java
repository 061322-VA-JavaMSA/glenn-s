package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	private ReimbursementDAO rd = new ReimbursementHibernate();
	
	
	public List<Reimbursement> getReimburse() {
		List<Reimbursement> reimburse = rd.getReimbursements();
		return reimburse;
	}
}
