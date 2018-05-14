package com.valuelabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.dao.TransactionHistoryDao;
import com.valuelabs.dao.TransactionHistoryDaoImpl;
@Service("transactionHistoryService")
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
	@Autowired(required=true)
	TransactionHistoryDao TransactionHistoryDao;
	@Override
	public List transactionHistory(String accountDetails) {
	List listofRecords =	TransactionHistoryDao.transactionHistory(accountDetails);
		return listofRecords;
	}

}
