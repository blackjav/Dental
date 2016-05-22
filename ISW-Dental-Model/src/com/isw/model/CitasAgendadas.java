package com.isw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="citas_agendadas")
public class CitasAgendadas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1815747164055686623L;
	@Id
	private long folio;
	private Paciente paciente;
	private Date fechaCita;
	private boolean status;
	
	public long getFolio() {
		return folio;
	}
	public void setFolio(long folio) {
		this.folio = folio;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Date getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
