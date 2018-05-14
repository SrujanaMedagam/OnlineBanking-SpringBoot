package com.valuelabs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.dao.TransactionHistoryDao;

@Repository
@Transactional
public class TransactionHistoryDaoImpl implements TransactionHistoryDao {
	@Autowired(required=true)
	private HibernateTemplate  hibernateTemplate;
	
	@Override
	public List transactionHistory(String accountDetails) {
		String hql = "from AccountTransactionDetails acc where acc.accountNumber=?";
		/*Query query=session.createQuery(" from AccountTransactionDetails acc where acc.accountNumber=:accountDetails");
		query.setParameter("accountDetails", accountDetails);
		List listofRecords=query.list();
		session.close();
		return listofRecords;*/
		return (List<String>) hibernateTemplate.find(hql,accountDetails);
		
	}

}
