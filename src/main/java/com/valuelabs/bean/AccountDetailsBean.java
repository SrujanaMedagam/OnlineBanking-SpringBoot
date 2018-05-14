package com.valuelabs.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

public class AccountDetailsBean {

	private String accName;

	private String accNumber;

	private double totalAmount;

	private String StatusOfAccount;

	private String accountType;

	private String accountOpenDate;

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getStatusOfAccount() {
		return StatusOfAccount;
	}

	public void setStatusOfAccount(String statusOfAccount) {
		StatusOfAccount = statusOfAccount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(String accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

}
