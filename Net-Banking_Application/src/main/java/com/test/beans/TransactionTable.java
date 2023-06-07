package com.test.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TransId;
	
	private LocalDate TransDate;
	private String Type;
	private Double amount;
	private Integer AccNo;
	
	public Integer getAccNo() {
		return AccNo;
	}

	public void setAccNo(Integer accNo) {
		AccNo = accNo;
	}

	public LocalDate getTransDate() {
		return TransDate;
	}

	public void setTransDate(LocalDate transDate) {
		TransDate = transDate;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTransId() {
		return TransId;
	}

	public void setTransId(Integer transId) {
		TransId = transId;
	}

	@Override
	public String toString() {
		return "TransactionTable [TransId=" + TransId + ", TransDate=" + TransDate + ", Type=" + Type + ", amount="
				+ amount + ", AccNo=" + AccNo + "]";
	}



}
