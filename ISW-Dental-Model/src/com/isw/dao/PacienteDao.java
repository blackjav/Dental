package com.isw.dao;

import java.util.List;

import com.isw.model.Paciente;


public interface PacienteDao {

	public void create(Paciente obj);
	public boolean update (Paciente obj);
	public Paciente findOne(Paciente obj);
	public List<Paciente> findAll();
	public boolean delete (Paciente obj);
	public void login(Paciente obj);
}
