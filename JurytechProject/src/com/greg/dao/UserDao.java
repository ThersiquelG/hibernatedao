package com.greg.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.greg.model.User;
import com.greg.util.HibernateUtil;

public class UserDao {
	public String addUser(User user) {

		//new transaction
		Transaction trns = null;


		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			session.save(user);
			System.out.println(user);
			//*session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return "SUCCESS";
	}
}
