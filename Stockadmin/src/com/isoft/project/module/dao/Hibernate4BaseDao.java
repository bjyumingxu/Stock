package com.isoft.project.module.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public  abstract  class Hibernate4BaseDao<T> {
	
	private SessionFactory sessionFactory;
	
	private Class<T> poclazz;
	
	
	public Hibernate4BaseDao(){
		
		Type genericSuperclass = this.getClass().getGenericSuperclass();
	    Type[] params = ((ParameterizedType)genericSuperclass).getActualTypeArguments();
	    poclazz = null;
	    if ((params.length > 0) && (params[0] != null)) {
	    	poclazz = (Class)params[0];
	    }
		
	}
	
	public String getClazzName(){
		
		return poclazz.getSimpleName();
		
	}
	
	

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	
	
	public void batchsave(List<T> list){
		
		Session session=openSession();
		session.beginTransaction();
		int i=0;
	
		for (T t : list) {
			
			session.save(t);
			
			if(i>=20){
				session.getTransaction().commit();
				session.flush();
				session.clear();
				session.beginTransaction();
				
				i=0;
			}
			i++;
		}
		
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}	
	
	
	public  T findById(Integer id) {
		
	Session session=openSession();
	T obj=	(T)openSession().get(poclazz, id);
		
	session.close();
	
       return  obj;
    }
	
	public  List<T> findAll() {
		
	Session session=	openSession();
	
	List<T> list  =session.createQuery("from " + poclazz.getSimpleName()).list();
	
	session.close();
	
        return list;
    }
	
	public  Map<String,Object> findByPage(Integer first,Integer max) {
		
	
		Map<String,Object> map=new HashMap<String, Object>();
		
		Session session=	openSession();
		
		Query query =session.createQuery("from " + poclazz.getSimpleName());
					
		query.setFirstResult(first); 
		
		query.setMaxResults(max);
				
	    List<T> list  = query.list();
	    
	    
	   String total=  session.createQuery("select count(*)  from  "+poclazz.getSimpleName()).uniqueResult().toString();
		
	   map.put("rows", list);
	   map.put("total", total);
	   
		session.close();
		
	        return map;
	    }
	
	
	
    public  void saveOrUpdate(T entity) {
     
     Session session=openSession();
     
     session.beginTransaction();
    	
     session.saveOrUpdate(entity);
    	
     session.getTransaction().commit();
     session.close();
    }

    public  T update(T entity) {
    	 Session session=openSession();
    	 session.beginTransaction();
    	session.update(entity);
    	session.getTransaction().commit();
    	   session.close();
        return entity;
    }

    public  void delete(T entity) {
    	Session session=openSession();
    	 session.beginTransaction();
    	session.delete(entity);
    	session.getTransaction().commit();
    	   session.close();
    }

    
    public  void deleteById(Long entityId) {
    	
    Session session=openSession(); 
    session.beginTransaction();
     T entity = (T) session.get(poclazz, entityId);
       delete(entity);
       session.getTransaction().commit();
       session.close();
    }
    
    public  void deleteById(String entityId) {
    	
        Session session=openSession(); 
        session.beginTransaction();
         T entity = (T) session.get(poclazz, entityId);
           delete(entity);
           session.getTransaction().commit();
           session.close();
        }
	
}
