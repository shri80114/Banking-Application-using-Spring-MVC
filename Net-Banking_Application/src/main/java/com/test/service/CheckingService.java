package com.test.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.test.beans.CreateAccount;
import com.test.dao.AccountDetails;
import com.test.utils.HibernateUtil;

@Service
public class CheckingService implements AccountDetails {

	static String uname;
	static String pass;
	static Integer AccNo;
	
	

	public static Integer getAccNo() {
		return AccNo;
	}

	public List<CreateAccount> checking(String email, String pass) {
		
		SessionFactory session = HibernateUtil.getSessionFactory();

		// System.out.println(session);
		uname=email;
		Session openSession = session.openSession();
		String query = "From CreateAccount where Email=:u";
		@SuppressWarnings("unchecked")
		Query<CreateAccount> query2 = openSession.createQuery(query);

		query2.setParameter("u", email);
		System.out.println(email);
		List<CreateAccount> list = query2.list();
		return list;
	}

	@Override
	public void newUser(CreateAccount account) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();

	}

	public static double balance(String uname) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// factory
		Session openSession = factory.openSession();
		String query = "From CreateAccount where Email=:u";
		@SuppressWarnings("unchecked")
		Query<CreateAccount> query2 = openSession.createQuery(query);
		query2.setParameter("u", uname);
		System.out.println(uname);

		List<CreateAccount> list = query2.list();
		double balance = 0;
		for (CreateAccount acc : list) {
			balance = acc.getAccountBalance();
			AccNo =acc.getAccountNumber();
		}
		return balance;
	}

}
