package com.curso.java.interfaces;

import java.util.List;

public interface DAO<E,K>{
	void insertar(E e);
	void eliminar(E e);
	void actualizar(E e);
	E buscarId(K k);
	List<E> listar();
}
	