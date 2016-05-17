package com.isw.model;

import java.util.Date;
import java.util.UUID;

public class SolicitudCita {
	
	private UUID folio;
	private Paciente paciente;
	private String descripcion;
	private Date fechaPedimento;
	private boolean status;
	
	
	public UUID getFolio() {
		return folio;
	}
	public void setFolio(UUID folio) {
		this.folio = folio;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaPedimento() {
		return fechaPedimento;
	}
	public void setFechaPedimento(Date fechaPedimento) {
		this.fechaPedimento = fechaPedimento;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
