package com.valuelabs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HomePageDaoImpl implements HomePageDao {

	@Autowired(required=true)
	private HibernateTemplate hibernateTemplate;

	@Override
	public List accountDetailsInfo(String accountDetails) {
		System.out.println("accountDetails:"+accountDetails);
		String hql = " from AccountDetails acc where acc.AccNumber = ? ";
		/*
		 * Query query=session.createQuery(
		 * "from AccountDetails where accNumber=:accountDetails");
		 * query.setParameter("accountDetails", accountDetails); List
		 * list1=query.list(); session.close();
		 */
		List list = (List<String>) hibernateTemplate.find(hql, accountDetails);
		if(!list.isEmpty()){
			System.out.println(list);
			System.out.println("list not empty");
			return list;
		}
		else{
			return list;
		}
		
	}

	@Override
	public List accountDetails(String accountDetailslist) {
		String hql = " from AccountDetails where accNumber=?";
		/*Query query = session.createQuery(" from AccountDetails where accNumber=:accountDetailslist");
		List list1 = query.list();*/
		return (List<String>) hibernateTemplate.find(hql, accountDetailslist);
	}

}
