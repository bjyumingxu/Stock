package com.isoft.project.module.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.isoft.project.module.po.Stockdata;
import com.isoft.project.module.po.SysUserinfo;

@Repository
public class SysUserinfoDao extends Hibernate4BaseDao<SysUserinfo>  {
	public List<SysUserinfo> findbyUserinfoId() {

		String hql = "select * from sys_userinfo";
		Session session = openSession();
		//System.out.println(session);
		return session.createSQLQuery(hql).list();

		// session.close();

	}
}