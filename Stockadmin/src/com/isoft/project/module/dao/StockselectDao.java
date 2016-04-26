package com.isoft.project.module.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.isoft.project.module.po.Stockdata;
import com.isoft.project.module.po.Stockindex;

@Repository
public class StockselectDao extends Hibernate4BaseDao<Stockindex> {

	public List<Stockdata> findbyStockTopId() {

		String hql = "select * from Stockdata group by stockdata.increPer order by stockdata.increPer desc limit 0,10";
		Session session = openSession();

		return session.createSQLQuery(hql).list();

		// session.close();

	}

	/**
	 * 精确查询
	 * 
	 * @param gid
	 * @return
	 */
	public List<Stockdata> findbyStockcxId(String gid) {

		String hql1 = "select * from Stockdata s where s.gid = '" + gid
				+ "' group by s.gid order by s.time desc limit 1 ";
		Session session = openSession();
		System.out.println(session);
		return session.createSQLQuery(hql1).list();

		// session.close();

	}

	/**
	 * 模糊查询
	 * 
	 * @param name
	 * @return
	 */
	public List<Stockdata> findbyStockmhcxId(String name) {
		// System.out.println("----"+name);
		try {
			String hql1 = "select distinct * from Stockdata s where s.name like '%"
					+ new String(name.getBytes("iso-8859-1"), "utf-8") + "%' group by s.name";
			Session session = openSession();
			List<Stockdata> list = session.createSQLQuery(hql1).list();
			System.out.println("test----" + list);
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

		// session.close();

	}

	public Map findbyStockIndexId() {

		Session session = openSession();

		List<Stockindex> list2 = session.createQuery("from Stockindex").list();
		Calendar cal = Calendar.getInstance();

		Date date = new Date();

		cal.setTime(date);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		Date date1 = cal.getTime();

		// System.out.println(date1);

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		Date date2 = cal.getTime();

		// System.out.println(date2);

		Query querys = session
				.createQuery("from Stockindex s where s.name='上证指数'");
		// querys.setDate(0, date1);
		// querys.setDate(1, date2);

		List slist = querys.list();

		Query queryz = session
				.createQuery("from Stockindex s where s.name='深证成指'");
		// queryz.setDate(0, date1);
		// queryz.setDate(1, date2);
		//
		List zlist = queryz.list();

		Map<String, List> map = new HashMap<String, List>();

		map.put("sindex", slist);
		map.put("zindex", zlist);

		System.out.println("sindex" + map.toString());

		session.close();

		return map;

	}

}
