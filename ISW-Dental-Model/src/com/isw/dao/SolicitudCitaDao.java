package com.isw.dao;

import java.util.List;

import com.isw.model.SolicitudCita;

public interface SolicitudCitaDao {

	public void create(SolicitudCita obj);
	public void update (SolicitudCita obj);
	public SolicitudCita findOne(SolicitudCita obj);
	public List<SolicitudCita> findAll();
	public boolean delete (SolicitudCita obj);
	public void login(SolicitudCita obj);
}
