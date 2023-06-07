package com.test.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.TransactionTable;
import com.test.dao.MiniStatements;
import com.test.utils.HibernateUtil_01;

@Service
@Transactional
public class Statements implements MiniStatements

{
	@Autowired
	CheckingService checkingService;
	String startDate;
	String endDate;
	Integer Acc = checkingService.AccNo;

	public List<TransactionTable> getMiniStatement(String Start, String End) {

		LocalDate startDate = LocalDate.parse(Start);
		LocalDate endDate = LocalDate.parse(End);
		System.out.println(startDate + " " + endDate);

		Session factory = HibernateUtil_01.getSessionFactory().openSession();
		Query createQuery = factory
				.createQuery("from TransactionTable where TransDate >=:s and TransDate <=:e");
		createQuery.setParameter("s", startDate);
		createQuery.setParameter("e", endDate);
		//createQuery.setParameter("a", checkingService.AccNo);
		List<TransactionTable> list = createQuery.list();
		
		for (TransactionTable t : list) {
			System.out.println(t.getTransId() + " " + t.getTransDate() + " " + t.getAmount() + " " + t.getAccNo());
		}
		System.out.println("------------------------------------------------------------");
		
	//	 list.stream().filter((x) -> x.getAccNo().equals(checkingService.AccNo)).forEach((y) -> System.out.println(y));

		return list;
	}

}
