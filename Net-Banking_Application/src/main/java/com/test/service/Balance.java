package com.test.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.CreateAccount;
import com.test.beans.TransactionTable;
import com.test.dao.CheckBalance;
import com.test.utils.HibernateUtil;
import com.test.utils.HibernateUtil_01;

@Service
@Transactional
public class Balance implements CheckBalance {

	@Autowired
	CheckingService checkingService;

	

	private String uname = checkingService.uname;
	private double balance = 0;
	private Integer Acc = 0;
	private Transaction transaction = null;

	@Override
	public double checkBalance(String uname) {
		double balance = 0.0;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			Query<CreateAccount> query = session.createQuery("From CreateAccount where Email=:name");
			query.setParameter("name", uname);
			List<CreateAccount> list = query.list();
			for (CreateAccount acc : list) {
				balance = acc.getAccountBalance();
			}
			System.out.println(balance);

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println(checkingService.uname);
		System.out.println(uname);
		return balance;
	}

	public void depositAmount(String bal) {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			System.out.println(bal);
			System.out.println(checkingService.uname);
			Query query3 = session.createQuery("from CreateAccount where Email=:u");
			query3.setParameter("u", checkingService.uname);
			List<CreateAccount> list = query3.list();
			System.out.println(list);
			for (CreateAccount acc : list) {
				balance = acc.getAccountBalance();
				Acc = acc.getAccountNumber();
			}
			System.out.println(Acc);
			double updateBalance = balance + Double.parseDouble(bal);
			System.out.println("Update balance " + updateBalance);
			String query = "UPDATE CreateAccount set AccountBalance=:b  where Email=:e";
			Query<CreateAccount> query2 = session.createQuery(query);
			query2.setParameter("b", updateBalance);
			query2.setParameter("e", checkingService.uname);
			int i = query2.executeUpdate();
			transaction.commit();
			System.out.println("Data updated " + i);
			TransInsert(bal, "Credited", Acc);

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	public List<CreateAccount> accountDetails(String email) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Query<CreateAccount> query = session.createQuery("From CreateAccount where Email=:e");
		query.setParameter("e", email);
		List<CreateAccount> list = query.list();
		return list;

	}

	@Override
	public Integer withdrawAmount(String amount) {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			System.out.println(amount);
			Query<CreateAccount> createQuery = session.createQuery("From CreateAccount where Email=:e");
			createQuery.setParameter("e", checkingService.uname);
			List<CreateAccount> list = createQuery.list();
			for (CreateAccount acc : list) {
				balance = acc.getAccountBalance();
				Acc = acc.getAccountNumber();
			}
			double updateBalance = balance - Double.parseDouble(amount);
			System.out.println(updateBalance);
			String query = "UPDATE CreateAccount set AccountBalance =:b  where Email=:e";
			@SuppressWarnings("unchecked")
			Query<CreateAccount> query2 = session.createQuery(query);
			query2.setParameter("b", updateBalance);
			query2.setParameter("e", checkingService.uname);
			int i = query2.executeUpdate();
			transaction.commit();
			System.out.println("Data updated " + i);
			TransInsert(amount, "Debited", Acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(amount);
	}

	static public void TransInsert(String bal, String s, Integer Id) {

		SessionFactory factory = HibernateUtil_01.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction2 = session.beginTransaction();
		TransactionTable tr = new TransactionTable();
		tr.setAccNo(Id);
		tr.setAmount(Double.parseDouble(bal));
		tr.setTransDate(LocalDate.now());
		tr.setType(s);

		session.save(tr);
		transaction2.commit();
		System.out.println("Data Inserted to Transaction table ");
	}


}
