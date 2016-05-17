package com.isw.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materiales  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8211367362655975537L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private long clave;
	private String nombre;
	private String descripcion;
	private long existencias;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getClave() {
		return clave;
	}
	public void setClave(long clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getExistencias() {
		return existencias;
	}
	public void setExistencias(long existencias) {
		this.existencias = existencias;
	}
	
	

}
