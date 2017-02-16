package com.workstream.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	//Serializable id is an id that is serializable (Integer is serializable)
	//get the pojo according to the id and Type of the pojo
	public T get(Class<T> entityClass, Serializable id);
	//save the entity
	public Serializable save(T entity);
	//update the entity
	public void update(T entity);
	//delete the entity
	public void delete(T entity);
	//delete the entity by Serializable id
	public void delete(Class<T> entityClass, Serializable id);
	//get all entity
	public List<T> getAll(Class<T> entityClass);
	//get the number of entities
	public long getCount(Class<T> entityClass);
}
