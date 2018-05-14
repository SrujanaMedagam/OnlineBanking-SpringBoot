package com.valuelabs.dao;

import java.util.List;

import org.hibernate.Session;

import com.valuelabs.bean.AccountTransactionDetailsBean;

public interface FundsTransferDao {
	//public boolean trnsferFunds(String accountDetails,Double amount);
	//public boolean trnsferFundsUpdate(String accountNumber,Double amount);
	public List balanceAmountAfterTransferFunds( String accountDetails);
	boolean transferFundsToTransactionHistory(
			AccountTransactionDetailsBean accountTransactionDetailsBean);
	public List totalAmountAfterTransferFunds( String accountNumber);
	boolean updatedTransferFundsToTransactionHistory(
			AccountTransactionDetailsBean accountTransactionDetailsBean);
	public List checkAmount( String accountDetails);
	boolean trnsferFunds(Double amount, String accountDetails);
	boolean trnsferFundsUpdate(Double amount, String accountNumber);


}
