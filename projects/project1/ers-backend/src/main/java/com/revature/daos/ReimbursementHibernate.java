/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
  
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
 
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			// define entity to be searched
			Root<Reimbursement> root = cq.from(Reimbursement.class);
			
			//define conditions
			Predicate predicateForReimbursementname = cb.equal(root.get("author"), u);
 
			cq.select(root).where(predicateForReimbursementname);
			cq.orderBy(cb.asc(root.get("id"))) ;
			
			reimburse = (List<Reimbursement>)  s.createQuery(cq).getResultList();			
		}
				
		return reimburse;
	}

	@Override
	public Reimbursement insertReimbursement(Reimbursement r) {
		r.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(r);
			r.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return r;
 
	}

}
