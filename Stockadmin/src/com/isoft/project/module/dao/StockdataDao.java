package com.isoft.project.module.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.isoft.project.module.po.Stockdata;


@Repository
public class StockdataDao  extends Hibernate4BaseDao<Stockdata>{

	
	
	public List<Stockdata> findbyStockinfoId(Integer id){
		
		
		Session session= openSession();
		
		List<Stockdata> list= session.createQuery("from Stockdata where stockinfoId=?").setInteger(0, id).list();
		
		session.close();
		
		return list;
		
		
		
	}
	
	
	
}
