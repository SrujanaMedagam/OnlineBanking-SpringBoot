package com.valuelabs.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.LoginDetailsBean;
import com.valuelabs.dao.LoginDao;
import com.valuelabs.dao.LoginDaoImpl;
import com.valuelabs.model.LoginDetails;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired(required=true)
	LoginDao loginDao;
	
	@Override
	public boolean checkUserLoginCredentials(String username, String password) {
		List list = loginDao.checkLoginCredentials( username, password);
		Iterator<String> iterator = list.iterator();
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checkIsAccountNumber(String accountNumber) {
		List list = loginDao.checkIsAccountNumber(accountNumber);
		Iterator<String> iterator = list.iterator();
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}
	@Override
	public List checkIsValidAccountNumber(String accountNumber) {
		List list = loginDao.checkIsAccountNumber(accountNumber);
		return list;
	}
	@Override
	public boolean checkUserId(String username) {
		List list = loginDao.checkIsUsername( username);
		Iterator<String> iterator = list.iterator();
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List checkUserAccountNumber(String username, String password) {
		System.out.println("checkUserAccountNumber");
		List list = loginDao.checkLoginCredentials( username, password);
		/*Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println("AccountNumber:::" + iterator.next());
		}*/
		return list;
	}

	public boolean newUserPermission(String accountNumber, String accountName, String username, String password, String address,
			String emailId,int phoneNumber, String panNumber,int aadharNumber,String accountType, String date) {

		LoginDetailsBean loginDetailsBean = new LoginDetailsBean();
		AccountDetailsBean accountDetailsBean = new AccountDetailsBean();
		loginDetailsBean.setAccountNumber(accountNumber);
		loginDetailsBean.setAccountName(accountName);
		loginDetailsBean.setUsername(username);
		loginDetailsBean.setPassword(password);
		loginDetailsBean.setAddress(address);
		loginDetailsBean.setEmailId(emailId);
		loginDetailsBean.setPhoneNumber(phoneNumber);
		loginDetailsBean.setPanNumber(panNumber);
		loginDetailsBean.setAadharNumber(aadharNumber);
		loginDetailsBean.setAccountType(accountType);
		loginDetailsBean.setAccountOpenDate(date);
		accountDetailsBean.setAccNumber(accountNumber);
		accountDetailsBean.setAccName(accountName);
		accountDetailsBean.setStatusOfAccount("Active");
		accountDetailsBean.setAccountOpenDate(date);
		accountDetailsBean.setAccountType(accountType);
		if (loginDao.newUserPermissionInfo( loginDetailsBean, accountDetailsBean)) {

			return true;
		}

		return false;
	}
	@Override
	public String getAccountNumber(String username, String password){
		String accountNumber = "" ;
		List list = loginDao.getAccountNumber( username, password);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			accountNumber =  (String) iterator.next();
		}
		return accountNumber;
		
	}
	
	@Override
	public boolean isAccountNumber(String username, String password){
		int accountNumber = 0 ;
		List list = loginDao.getAccountNumber( username, password);
		Iterator iterator = list.iterator();
		if(list.isEmpty()){
			return false;
		}
				
		return true;
		
	}
	
	@Override
	public List getProfileData(String accountNumber){
		List list = loginDao.getProfile(accountNumber);
		return list;
	}
	@Override
	public boolean getProfileUpdate(String accountNumber,String address,String emailId,int phoneNumber,String panNumber,int aadharNumber){
		// loginDao.profileUpdate(con.getConnection(),accountNumber,address,emailId,phoneNumber,panNumber,aadharNumber);
		return loginDao.profileUpdate(accountNumber,address,emailId,phoneNumber,panNumber,aadharNumber);
	}
	

	/*@Override
	public List<LoginDetails> getallAccounts() {
		loginDao = new LoginDaoImpl();
		con = new HibernateConnector();
		List list = loginDao.getAllAccounts(con.getConnection());
		return list;
	}*/

}
