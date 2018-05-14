package com.valuelabs.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.dao.HomePageDao;
import com.valuelabs.dao.HomePageDaoImpl;
import com.valuelabs.dao.LoginDao;
import com.valuelabs.dao.LoginDaoImpl;
@Service("homePageService")
public class HomePageServiceImpl implements HomePageService {
	
	@Autowired(required=true)
	LoginDao loginDao;
	@Autowired(required=true)
	HomePageDao homePageDao;
	
	@Override
	public List checkUserLoginCredentials(String username, String password) {
		List list = loginDao.checkLoginCredentials(username, password);
		return list;
	}
	@Override
	public List checkAccountDetails(String accountDetails) {
		System.out.println(accountDetails);
		List list1 = null;
		try{
		 list1=homePageDao.accountDetailsInfo(accountDetails);
		}catch(NullPointerException e){
			System.out.println("Exception");
		}
	
		
		return list1;
	}

}
