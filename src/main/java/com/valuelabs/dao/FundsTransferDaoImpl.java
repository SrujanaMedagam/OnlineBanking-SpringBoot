package com.valuelabs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.model.AccountTransactionDetails;

@Repository
@Transactional
public class FundsTransferDaoImpl implements FundsTransferDao {
	@Autowired(required=true)
	AccountTransactionDetails accountTransactionDetails;
	@Autowired(required=true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@Override
	public boolean trnsferFunds(Double amount,String accountDetails) {
		String hql = "UPDATE AccountDetails acc set acc.totalAmount = acc.totalAmount - ? WHERE acc.AccNumber = ? ";
		/*Transaction tx= session.beginTransaction();
		Query query=session.createQuery("UPDATE AccountDetails set totalAmount = totalAmount - :amount WHERE AccNumber=:accountDetails");
		query.setParameter("accountDetails", accountDetails);
		query.setParameter("amount", amount);
		int result = query.executeUpdate();
		tx.commit();
		session.close();*/
		int result = hibernateTemplate.bulkUpdate(hql , amount , accountDetails);
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List checkAmount(String accountDetails) {
		System.out.println(accountDetails);
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber = ? ";
		/*Transaction tx= session.beginTransaction();
		Query query=session.createQuery("select acc.totalAmount from AccountDetails acc where acc.AccNumber=:accountDetails");
		query.setParameter("accountDetails", accountDetails);
		List balanceAmount = query.list();
		tx.commit();
		session.close();*/
		return (List<String>) hibernateTemplate.find(hql , accountDetails);
	}
	@Override
	public boolean trnsferFundsUpdate(Double amount ,String accountNumber) {
		String hql= " UPDATE AccountDetails acc set acc.totalAmount = acc.totalAmount + ? WHERE acc.AccNumber = ? ";
		/*Transaction tx= session.beginTransaction();
		Query query=session.createQuery("UPDATE AccountDetails set totalAmount = totalAmount + :amount WHERE AccNumber=:accountNumber");
		query.setParameter("accountNumber", accountNumber);
		query.setParameter("amount", amount);
		int result = query.executeUpdate();
		tx.commit();
		session.close();*/
		int result = hibernateTemplate.bulkUpdate(hql,amount, accountNumber);
		
		return true;
	}
	public List balanceAmountAfterTransferFunds( String accountDetails) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber= ?";
		/*Transaction tx= session.beginTransaction();
		Query query=session.createQuery("select acc.totalAmount from AccountDetails acc where acc.AccNumber=:accountDetails");
		query.setParameter("accountDetails", accountDetails);
		List balanceAmount = query.list();
		tx.commit();
		session.close();*/
		return (List<String>) hibernateTemplate.find(hql,accountDetails);
	}
	public List totalAmountAfterTransferFunds( String accountNumber) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber = ? ";
		/*Transaction tx= session.beginTransaction();
		Query query=session.createQuery("select acc.totalAmount from AccountDetails acc where acc.AccNumber=:accountNumber");
		query.setParameter("accountNumber", accountNumber);
		List balanceAmount = query.list();
		tx.commit();
		session.close();*/
		return (List<String>) hibernateTemplate.find(hql,accountNumber);
	
	}
	
	@Override
	public boolean transferFundsToTransactionHistory( AccountTransactionDetailsBean accountTransactionDetailsBean) {
		accountTransactionDetails.setAccountNumber(accountTransactionDetailsBean.getAccountNumber());
		accountTransactionDetails.setToAccount(accountTransactionDetailsBean.getToAccount());
		accountTransactionDetails.setTransactionDate(accountTransactionDetailsBean.getTransactionDate());
		accountTransactionDetails.setAmount(accountTransactionDetailsBean.getAmount());
		accountTransactionDetails.setTransactionType(accountTransactionDetailsBean.getTransactionType());
		accountTransactionDetails.setBalanceAmount(accountTransactionDetailsBean.getBalanceAmount());
		accountTransactionDetails.setRemarks(accountTransactionDetailsBean.getRemarks());
		hibernateTemplate.save(accountTransactionDetails);
		return true;
	}
	@Override
	public boolean updatedTransferFundsToTransactionHistory( AccountTransactionDetailsBean accountTransactionDetailsBean) {
		accountTransactionDetails.setAccountNumber(accountTransactionDetailsBean.getAccountNumber());
		accountTransactionDetails.setToAccount(accountTransactionDetailsBean.getToAccount());
		accountTransactionDetails.setTransactionDate(accountTransactionDetailsBean.getTransactionDate());
		accountTransactionDetails.setAmount(accountTransactionDetailsBean.getAmount());
		accountTransactionDetails.setTransactionType(accountTransactionDetailsBean.getTransactionType());
		accountTransactionDetails.setBalanceAmount(accountTransactionDetailsBean.getBalanceAmount());
		accountTransactionDetails.setRemarks(accountTransactionDetailsBean.getRemarks());
		hibernateTemplate.save(accountTransactionDetails);
		return true;
	}

}
