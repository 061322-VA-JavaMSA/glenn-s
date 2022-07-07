package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.util.HibernateUtil;

public class ReimbursementTypeHibernate implements ReimbursementTypeDAO{

	@Override
	public ReimbursementType getReimbursementTypeById(int id) {
		// TODO Auto-generated method stub
		ReimbursementType type = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			type = s.get(ReimbursementType.class, id);
		}
		
		return type;
	}

}
