package com.isw.dao;

import java.util.List;

import com.isw.model.Materiales;


public interface MaterialesDao {
	
	public void create(Materiales obj);
	public void update (Materiales obj);
	public Materiales findOne(Materiales obj);
	public List<Materiales> findAll();
	public boolean delete (Materiales obj);
	public void login(Materiales obj);

}
