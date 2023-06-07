package com.test.beans;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CreateAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = true, unique = true)
	private int AccountNumber;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private String Gender;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date date;
	private String PhoneNumber;
	@Column(length = 10, precision = 4)
	private double AccountBalance;

	

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public double getAccountBalance() {
		return AccountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		AccountBalance = accountBalance;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "CreateAccount [AccountNumber=" + AccountNumber + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Email=" + Email + ", Password=" + Password + ", Gender=" + Gender + ", date=" + date
				+ ", PhoneNumber=" + PhoneNumber + ", AccountBalance=" + AccountBalance + "]";
	}


}
