package com.valuelabs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;


@Table(name="AccountDetails")
@Entity()
@Service("accountDetails")
public class AccountDetails implements Serializable{
	@Id
	@Column
	private String AccNumber;
	@Column
	private String AccName;
	@Column
	private double totalAmount;
	@Column
	private String StatusOfAccount;
	@Column
	private String accountType;
	@Column
	private String accountOpenDate;
	
	
	public String getAccNumber() {
		return AccNumber;
	}
	public void setAccNumber(String accNumber) {
		AccNumber = accNumber;
	}
	public String getAccName() {
		return AccName;
	}
	public void setAccName(String accName) {
		AccName = accName;
	}
	public String getStatusOfAccount() {
		return StatusOfAccount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setStatusOfAccount(String statusOfAccount) {
		StatusOfAccount = statusOfAccount;
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
