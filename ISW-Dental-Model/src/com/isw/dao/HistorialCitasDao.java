package com.isw.dao;

import java.util.List;

import com.isw.model.HistorialCitas;


public interface HistorialCitasDao {
	
	public void create(HistorialCitas obj);
	public void update (HistorialCitas obj);
	public HistorialCitas findOne(HistorialCitas obj);
	public List<HistorialCitas> findAll();
	public boolean delete (HistorialCitas obj);
	public void login(HistorialCitas obj);

}
