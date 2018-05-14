package com.valuelabs.dao;

import java.util.List;

import org.hibernate.Session;

import com.valuelabs.bean.AccountDetailsBean;



public interface HomePageDao {
	public List accountDetailsInfo(String accountDetailslist);

	List accountDetails(String accountDetailslist);

}
