package com.curso.java.entidades;

import java.io.Serializable;

public final class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipo;
	private String numero;

	public Documento() {

	}

	public Documento(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Documento [tipo=" + tipo + ", numero=" + numero + "]";
	}

}
