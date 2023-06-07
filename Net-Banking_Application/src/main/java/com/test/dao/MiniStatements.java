package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.beans.TransactionTable;

@Repository
public interface MiniStatements {
	
	public  List<TransactionTable> getMiniStatement(String Start,String End);
	

}
