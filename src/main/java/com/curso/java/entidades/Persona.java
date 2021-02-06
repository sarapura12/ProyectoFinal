package com.curso.java.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author rapid
 *
 */
public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	private Documento documento;
	private String descripcion;
	private Date fechaNacimiento;
	private Date fechaCreacion;
	private Boolean activo;
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(Documento documento, String descripcion, Date fechaNacimiento, Date fechaCreacion) {
		this.documento = documento;
		this.descripcion = descripcion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCreacion = fechaCreacion;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Persona [" + documento + ", descripcion=" + descripcion + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}

}
