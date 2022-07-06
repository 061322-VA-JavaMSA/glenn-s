/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;
 
public class ReimbursementHibernate implements ReimbursementDAO{

	@Override
	public List<Reimbursement> getReimbursements() {
		// TODO Auto-generated method stub
		List<Reimbursement> reimburse = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimburse = s.createQuery("from Reimbursement", Reimbursement.class).list();
 		}
		
		return reimburse;
	}

}
