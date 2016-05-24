package com.isw.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5917666040547827624L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String apellidPat;
	private String apellidoMat;
	private String telefono;
	private long visitas;
	private String usuario;
	private String contraseña;
	
	
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
	public String getApellidPat() {
		return apellidPat;
	}
	public void setApellidPat(String apellidPat) {
		this.apellidPat = apellidPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public long getVisitas() {
		return visitas;
	}
	public void setVisitas(long visitas) {
		this.visitas = visitas;
	}
	
	

}
