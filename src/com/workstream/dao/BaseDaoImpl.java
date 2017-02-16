package com.workstream.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements BaseDao<T> {

	//---------------------------get sessionFactory--------------------------------
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	//--------------------------------CRUD--------------------------------------------
	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClass, Serializable id) {
		String hql = "delete from "+entityClass.getSimpleName()+" e where e.id = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClass, Serializable id) {
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> entityClass) {
		String hql = "from " + entityClass.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	@Override
	public long getCount(Class<T> entityClass) {
		String hql = "SELECT count(e) from "+entityClass.getSimpleName()+" e" ;
		return getSession().createQuery(hql).executeUpdate();
	}

	//--------------------------------get entity by hql-----------------------------------------
	@SuppressWarnings("unchecked")
	public List<T> find(String hql){
		return (List<T>)getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object...parameters){
		Query query = getSession().createQuery(hql);
		for(int i=0; i<parameters.length; i++){
			query.setParameter(i, parameters[i]);
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql, int pageNo, int pageSize){
		Query query = getSession().createQuery(hql);
		query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql, int pageNo, int pageSize, Object...parameters){
		Query query = getSession().createQuery(hql);
		for(int i=0; i<parameters.length; i++){
			query.setParameter(i, parameters[i]);
		}
		return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
	}
	
	
}
