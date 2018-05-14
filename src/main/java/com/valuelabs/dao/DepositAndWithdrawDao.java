package com.valuelabs.dao;

import java.util.List;

import org.hibernate.Session;

import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.AccountTransactionDetailsBean;

public interface DepositAndWithdrawDao {
	//public boolean depositAccNumber(String accountNumber,Double amount);
	public List depositAccNumber(String accountNumber);
	public List withdrawAccNumber(String accountNumber);
	public boolean withdrawAccNumber(String accountNumber,Double amount);
	boolean depostAndWithdrawAmountToTransactionHistory(
			AccountTransactionDetailsBean accountTransactionDetailsBean);
	public List balanceAmountAfterDeposit(String accountNumber);
	public List balanceAmountAfterWithdraw(String accountNumber);
	public List isAmountAvailable( String accountNumber);
	boolean depositAccNumber(Double amount, String accountNumber);

}
