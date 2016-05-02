package com.isw.model;

import java.util.Date;
import java.util.UUID;

public class Paciente {
	
	private long id;
	private String nombre;
	private String apellido;
	private int visitas;
	private boolean status;
	private Date visita;
	private UUID uuid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getVisitas() {
		return visitas;
	}
	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getVisita() {
		return visita;
	}
	public void setVisita(Date visita) {
		this.visita = visita;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	

}
