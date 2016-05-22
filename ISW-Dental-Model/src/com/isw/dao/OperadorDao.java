package com.isw.dao;

import java.util.List;


import com.isw.model.Operador;

public interface OperadorDao {
	public void create(Operador obj);
	public boolean update (Operador obj);
	public Operador findOne(Operador obj);
	public List<Operador> findAll();
	public boolean delete (Operador obj);
	public void login(Operador obj);

}
