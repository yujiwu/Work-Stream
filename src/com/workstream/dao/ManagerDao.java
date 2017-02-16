package com.workstream.dao;

import java.util.List;

import com.workstream.pojo.Manager;

public class ManagerDao extends BaseDaoImpl<Manager>{
	
	public List<Manager> findByNameAndPass(Manager mgr){
		String hql = "From Manager m where m.name = ? and m.password=?";
		return find(hql, mgr.getName(), mgr.getPassword()); 
	}
}
