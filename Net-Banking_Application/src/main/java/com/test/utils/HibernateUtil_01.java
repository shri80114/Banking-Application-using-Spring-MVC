package com.test.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_01 {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		
		Configuration con=new Configuration();
		con.configure("hibernate.cfg1.xml");
		try {
			sessionFactory =con.buildSessionFactory();
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return sessionFactory;
	}

}
