package com.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CheckBalance {
	
	public  double checkBalance(String uname);
	public Integer withdrawAmount(String amount);
}
