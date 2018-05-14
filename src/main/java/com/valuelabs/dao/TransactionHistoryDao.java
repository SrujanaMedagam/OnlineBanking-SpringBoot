package com.valuelabs.dao;

import java.util.List;

import org.hibernate.Session;

public interface TransactionHistoryDao {
	public List transactionHistory(String accountDetails);

}
