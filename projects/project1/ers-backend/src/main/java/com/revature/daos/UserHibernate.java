/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.Query;
 
public class UserHibernate implements UserDAO {
	
	@Override
	public User insertUser(User u) {
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(User.class, id);
		}
		
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			String hql = "FROM User u WHERE u.username =  :username ";
				Query query = s.createQuery(hql);
				query.setParameter("username",username);
				user = (User) query.getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}
}
