package com.valuelabs.service;

import java.util.List;
public interface DepositAndWithdrawService {
	public String depositAmount(String accountNumber);
	public boolean depositAmount(String accountNumber,Double amount);
	public String withdrawAmount(String accountNumber);
	public boolean withdrawAmount(String accountNumber,Double amount);
	public void depositAndWithdrawAmountToTransactionHistory(String accountNumber, Double amount, String transactionDate,String transactionType,Double balanceAmount,String toAccount,String remarks);
	public double balanceAmountAfterDeposit(String accountNumber);
	public double balanceAmountAfterWithdraw(String accountNumber);
	

}
