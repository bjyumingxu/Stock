package com.isoft.project.module.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.isoft.project.module.po.Stockinfo;

/**
 * @ProjectName:MVCProject
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年4月19日 上午9:37:42
 */
@Repository
public class StockInfoDao  extends Hibernate4BaseDao<Stockinfo>{

	 
	public void clearStockInfoByMysql(){
				
		openSession().createSQLQuery("TRUNCATE STOCKINFO").executeUpdate();

	}
	
	
	
	public List<Stockinfo> findDataStockinfoList(){
		
		Session session= openSession();
		
		List list=session.createQuery("from "+getClazzName()+" where status=1").list();
		session.close();
		
		return list;
		
	}
	
	
	
	
	
	
}
