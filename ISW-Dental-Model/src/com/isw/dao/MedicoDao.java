package com.isw.dao;

import java.util.List;

import com.isw.model.Medico;


public interface MedicoDao {
	public void create(Medico obj);
	public void update (Medico obj);
	public Medico findOne(Medico obj);
	public List<Medico> findAll();
	public boolean delete (Medico obj);
	public void login(Medico obj);
}
