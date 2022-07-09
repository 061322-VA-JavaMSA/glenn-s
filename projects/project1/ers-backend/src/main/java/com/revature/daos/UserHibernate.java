/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserHibernate implements UserDAO {

	@Override
	public User insertUser(User u) {
		u.setId(-1);
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		} catch (ConstraintViolationException e) {
			// log it
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		User user = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			user = s.get(User.class, id);
		}

		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			String hql = "FROM User u WHERE u.username =  :username ";
			Query query = s.createQuery(hql);
			query.setParameter("username", username);
			user = (User) query.getSingleResult();
		}

		return user;
	}


	@SuppressWarnings("deprecation")
	@Override
	public boolean updatetUser(User u) {
		// TODO Auto-generated method stub
		int rowsChanged = -1;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			Transaction trans = s.beginTransaction();

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaUpdate<User> cu = cb.createCriteriaUpdate(User.class);
			Root<User> root  = cu.from(User.class);
			String passwordString = u.getPassword();
			
			cu.set(root.get("first_name"), u.getFirst_name());
			cu.set(root.get("last_name"), u.getLast_name());
			cu.set(root.get("email"), u.getEmail());
			
			if(passwordString != null && !passwordString.isEmpty()) {
				cu.set(root.get("password"), passwordString);
			}
			cu.where(cb.equal(root.get("id"),u.getId()));
 			rowsChanged =s.createQuery(cu).executeUpdate();
			if (rowsChanged < 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<User> getByRole(Role role) {
		List<User> users = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Query  query = s.createQuery("from User u where role = :role", User.class);
			query.setParameter("role", role );

			users = query.getResultList();
		}

		return users;
	}

}
