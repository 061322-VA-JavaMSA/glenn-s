package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.util.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDAO {

	@Override
	public ReimbursementStatus getReimbursementStatusById(int id) {
		// TODO Auto-generated method stub
		ReimbursementStatus status = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			status = s.get(ReimbursementStatus.class, id);
		}
		
		return status;
	}

}
