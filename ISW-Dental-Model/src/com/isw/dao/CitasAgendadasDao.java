package com.isw.dao;

import java.util.List;

import com.isw.model.CitasAgendadas;

public interface CitasAgendadasDao {
	
	public void create(CitasAgendadas obj);
	public void update (CitasAgendadas obj);
	public CitasAgendadas findOne(CitasAgendadas obj);
	public List<CitasAgendadas> findAll();
	public boolean delete (CitasAgendadas obj);
	public void login(CitasAgendadas obj);

}
