package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.beans.CreateAccount;

@Repository
public interface AccountDetails {
	
	public List<CreateAccount> checking(String email,String pass);
	public void newUser(CreateAccount account);
	

}
