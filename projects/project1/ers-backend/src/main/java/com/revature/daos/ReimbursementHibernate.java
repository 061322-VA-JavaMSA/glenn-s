/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.Query;
 
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

	@Override
	public List<Reimbursement>  getByAuthor(User u) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimburse = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			String hql = "FROM Reimbursement r WHERE r.author =  :author order by id ";

				Query query = s.createQuery(hql);
				query.setParameter("author",u);
				reimburse = (List<Reimbursement>) query.getResultList();
		}
				
		return reimburse;
	}

}
