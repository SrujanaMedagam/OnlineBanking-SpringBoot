package com.valuelabs.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.bean.LoginDetailsBean;
import com.valuelabs.dao.DepositAndWithdrawDao;
import com.valuelabs.dao.DepositAndWithdrawDaoImpl;
import com.valuelabs.dao.LoginDaoImpl;
@Service("depositAndWithdrawService")
public class DepositAndWithdrawServiceImpl implements DepositAndWithdrawService {
	@Autowired(required=true)
	DepositAndWithdrawDao depositAndWithdrawDao;
	@Autowired(required=true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;

	@Override
	public String depositAmount(String accountNumber) {
		String result;
		System.out.println("DepositAndWithdrawServiceImpl");
		List listofAccounts = depositAndWithdrawDao.depositAccNumber( accountNumber);
		if (listofAccounts.contains(accountNumber)) {
			System.out.println("Contains accountNumber::" + accountNumber);
			result = accountNumber;
		} else {
			System.out.println("not Contains accountNumber::");
			result = "";
		}
		return result;
	}

	@Override
	public boolean depositAmount(String accountNumber, Double amount) {
		System.out.println("DepositAndWithdrawServiceImpl");
		return depositAndWithdrawDao.depositAccNumber(amount ,  accountNumber);
	}

	@Override
	public String withdrawAmount(String accountNumber) {
		System.out.println("DepositAndWithdrawServiceImpl");
		List listofAccounts = depositAndWithdrawDao.withdrawAccNumber( accountNumber);
		if (listofAccounts.contains(accountNumber)) {
			System.out.println("Contains accountNumber::" + accountNumber);
		}
		return accountNumber;
	}

	public boolean withdrawAmount(String accountNumber, Double amount) {
		String result;
		double totalAmount = 0;
		System.out.println("DepositAndWithdrawServiceImpl");
		List list= depositAndWithdrawDao.isAmountAvailable( accountNumber);
		Iterator it = list.iterator();
		while(it.hasNext()){
			  totalAmount = (double) it.next();
		}
		System.out.println("amount:"+totalAmount);
		if(totalAmount>=amount){
			depositAndWithdrawDao.withdrawAccNumber(accountNumber, amount);
			return true;
		}
		return false;
	}
	public void depositAndWithdrawAmountToTransactionHistory(String accountNumber, Double amount, String transactionDate,
			String transactionType, Double balanceAmount, String toAccount,String remarks) {
		System.out.println("withdrawAmountToTransactionHistory Service");
		accountTransactionDetailsBean.setAccountNumber(accountNumber);
		accountTransactionDetailsBean.setTransactionDate(transactionDate);
		accountTransactionDetailsBean.setAmount(amount);
		accountTransactionDetailsBean.setTransactionType(transactionType);
		accountTransactionDetailsBean.setBalanceAmount(balanceAmount);
		accountTransactionDetailsBean.setRemarks(remarks);
		if (depositAndWithdrawDao.depostAndWithdrawAmountToTransactionHistory(
				accountTransactionDetailsBean)) {
			System.out.println("withdrawAmountToTransactionHistory done");
		}
	}
	@Override
	public double balanceAmountAfterDeposit(String accountNumber) {
		double totalAmount = 0;
		List list = depositAndWithdrawDao.balanceAmountAfterDeposit( accountNumber);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			totalAmount = (double) iterator.next();
		}
		return totalAmount;
	}
	@Override
	public double balanceAmountAfterWithdraw(String accountNumber) {
		double totalAmount = 0;
		List list = depositAndWithdrawDao.balanceAmountAfterWithdraw( accountNumber);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			totalAmount = (double) iterator.next();
		}
		return totalAmount;
	}
}
