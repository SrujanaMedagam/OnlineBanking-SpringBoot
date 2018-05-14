package com.valuelabs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;
import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.LoginDetailsBean;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.LoginDetails;
@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired(required=true)
	private HibernateTemplate  hibernateTemplate;
	@Autowired(required=true)
	LoginDetails loginDetails;
	@Autowired(required=true)
	AccountDetails accountDetails ;
	
	@Override
	public List checkLoginCredentials(String username,String password) {
		/*List list;
		try{*/
		String hql="Select user.accountNumber from LoginDetails user where user.username=? and user.password=?";
		/*Query query=session.createQuery(hql);
		query.setParameter("username", username);
        query.setParameter("password", password);
		 list=query.list();
		}finally{
			if(session!=null){
			session.close();
			}
		}
		*/
		return (List<String>) hibernateTemplate.find(hql,username,password);
	}
	@Override
	public boolean newUserPermissionInfo(LoginDetailsBean loginDetailsBean, AccountDetailsBean accountDetailsBean) {
		loginDetails.setAccountNumber(loginDetailsBean.getAccountNumber());
		loginDetails.setAccountName(loginDetailsBean.getAccountName());
		loginDetails.setUsername(loginDetailsBean.getUsername());
		loginDetails.setPassword(loginDetailsBean.getPassword());
		loginDetails.setAddress(loginDetailsBean.getAddress());
		loginDetails.setEmailId(loginDetailsBean.getEmailId());	
		loginDetails.setPhoneNumber(loginDetailsBean.getPhoneNumber());
		loginDetails.setPanNumber(loginDetailsBean.getPanNumber());
		loginDetails.setAadharNumber(loginDetailsBean.getAadharNumber());
		loginDetails.setAccountType(loginDetailsBean.getAccountType());
		loginDetails.setAccountOpenDate(loginDetailsBean.getAccountOpenDate());
		accountDetails.setAccNumber(accountDetailsBean.getAccNumber());
		accountDetails.setAccName(accountDetailsBean.getAccName());
		accountDetails.setStatusOfAccount("Active");
		accountDetails.setAccountType(accountDetailsBean.getAccountType());
		accountDetails.setAccountOpenDate(accountDetailsBean.getAccountOpenDate());
		hibernateTemplate.save(loginDetails);
		hibernateTemplate.save(accountDetails);
		
		return true;
	}
	@Override
	public List checkIsAccountNumber(String accountNumber) {
		
		String hql="Select user.accountNumber from LoginDetails user where user.accountNumber=?";
		/*Query query=session.createQuery(hql);
		query.setParameter("accountNumber", accountNumber);
		 list=query.list();
		}finally{
			if(session!=null){
			session.close();
			}
		}*/
		
		return (List<String>) hibernateTemplate.find(hql,accountNumber);
	}
	@Override
	public List checkIsUsername(String username) {
	
		String hql="Select user.username from LoginDetails user where user.username=?";
		/*Query query=session.createQuery(hql);
		query.setParameter("username", username);
		List list=query.list();
		session.close();*/
		return (List<String>) hibernateTemplate.find(hql,username);
	}
	@Override
	public List getAccountNumber(String username, String password){
		String hql="Select user.accountNumber from LoginDetails user where user.username=? and user.password=?";
		/*Query query=session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list=query.list();
		return list;*/
		return (List<String>) hibernateTemplate.find(hql,username,password);
	}
	@Override
	public List getProfile(String accountNumber){
		String hql="from LoginDetails user where user.accountNumber=?";
		/*Query query=session.createQuery(hql);
		query.setParameter("accountNumber", accountNumber);
		List list=query.list();
		return list;*/
		return (List<String>) hibernateTemplate.find(hql,accountNumber);
	}
	@Override
	public boolean profileUpdate(String accountNumber, String address, String emailId, int phoneNumber,
			String panNumber, int aadharNumber) {
		String hql = "UPDATE AccountDetails set address = :address and emailId =:emailId and phoneNumber = :phoneNumber and panNumber = :panNumber and aadharNumber = :aadharNumber WHERE AccNumber=:accountNumber";
		
		/*Query query=session.createQuery("UPDATE AccountDetails set address = :address and emailId =:emailId and phoneNumber = :phoneNumber and panNumber = :panNumber and aadharNumber = :aadharNumber WHERE AccNumber=:accountNumber");
		query.setParameter("accountNumber", accountNumber);
		query.setParameter("address", address);
		query.setParameter("emailId", emailId);
		query.setParameter("phoneNumber", phoneNumber);
		query.setParameter("panNumber", panNumber);
		query.setParameter("aadharNumber", aadharNumber);
		int result = query.executeUpdate();
		tx.commit();
		session.close();*/
		int result = hibernateTemplate.bulkUpdate(hql, accountNumber,address,emailId,phoneNumber,panNumber,aadharNumber);
		return true;
	}

}
