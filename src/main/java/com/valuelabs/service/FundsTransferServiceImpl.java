package com.valuelabs.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.dao.DepositAndWithdrawDaoImpl;
import com.valuelabs.dao.FundsTransferDao;
import com.valuelabs.dao.FundsTransferDaoImpl;
@Service("fundsTransferService")
public class FundsTransferServiceImpl implements FundsTransferService {
	@Autowired(required=true)
	FundsTransferDao fundsTransferDao;

	@Autowired(required=true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;
	
	@Override
	public boolean trnsferFunds(String accountDetails, Double amount) {
		double totalAmount = 0 ;
	List list= 	fundsTransferDao.checkAmount(accountDetails);
	Iterator iterator = list.iterator();
	while (iterator.hasNext()) {
		 totalAmount = (double) iterator.next();
	}
		if (totalAmount>=amount) {
			fundsTransferDao.trnsferFunds(amount,accountDetails);
			return true;
		}
		return false;
	}

	@Override
	public boolean trnsferFundsUpdate(String accountNumber, Double amount) {
		if (fundsTransferDao.trnsferFundsUpdate(amount , accountNumber)) {
			return true;
		}
		return false;
	}

	// balanceAmountAfterTransferFunds
	@Override
	public double balanceAmountAfterTransferFunds(String accountDetails) {
		double totalAmount = 0;
		List list = fundsTransferDao.balanceAmountAfterTransferFunds( accountDetails);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			totalAmount = (double) iterator.next();
		}
		return totalAmount;
	}

	@Override
	public double totalAmountAfterTransferFunds(String accountNumber) {
		double totalAmount = 0;
		List list = fundsTransferDao.totalAmountAfterTransferFunds( accountNumber);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			totalAmount = (double) iterator.next();
		}
		return totalAmount;
	}

	public void transferFundsToTransactionHistory(String accountDetails, String accountNumber, Double amount,
			String transactionDate, String transactionType, Double balanceAmount,String remarks) {
	
		accountTransactionDetailsBean.setAccountNumber(accountDetails);
		accountTransactionDetailsBean.setToAccount(accountNumber);
		accountTransactionDetailsBean.setTransactionDate(transactionDate);
		accountTransactionDetailsBean.setAmount(amount);
		accountTransactionDetailsBean.setTransactionType(transactionType);
		accountTransactionDetailsBean.setBalanceAmount(balanceAmount);
		accountTransactionDetailsBean.setRemarks(remarks);
		fundsTransferDao.transferFundsToTransactionHistory( accountTransactionDetailsBean);
	}

	@Override
	public void updatedTransferFundsToTransactionHistory(String accountDetails, String accountNumber, Double amount,
			String transactionDate, String transactionType, double totalAmount,String remarks) {
		accountTransactionDetailsBean.setAccountNumber(accountNumber);
		accountTransactionDetailsBean.setToAccount(accountDetails);
		accountTransactionDetailsBean.setTransactionDate(transactionDate);
		accountTransactionDetailsBean.setAmount(amount);
		accountTransactionDetailsBean.setTransactionType(transactionType);
		accountTransactionDetailsBean.setBalanceAmount(totalAmount);
		accountTransactionDetailsBean.setRemarks(remarks);
		fundsTransferDao.transferFundsToTransactionHistory( accountTransactionDetailsBean);
		}
	}

