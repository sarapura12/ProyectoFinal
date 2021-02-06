package com.curso.java.entidades;

import java.io.Serializable;

import com.curso.java.interfaces.Patrones;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String descripcion;
	private String clave;
	private boolean activo;

	public Usuario() {
	}

	public Usuario(String descripcion, String clave, boolean activo) throws Exception {
		setDescripcion(descripcion);
		setClave(clave);
		this.activo = activo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws Exception {
		if(!Patrones.esCorreo(descripcion)) {
			this.descripcion = null;
		}
		this.descripcion = descripcion;
	}

	public String getClave() {
		
		return clave;
	}

	public void setClave(String clave) throws Exception {
		if(!Patrones.esContra(clave)) {
			this.descripcion = null;
		}
		this.clave = clave;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Usuario [descripcion=" + descripcion + ", clave=" + clave + ", activo=" + activo + "]";
	}

}
