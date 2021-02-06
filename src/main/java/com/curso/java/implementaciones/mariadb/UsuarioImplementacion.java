package com.curso.java.implementaciones.mariadb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.curso.java.entidades.Usuario;
import com.curso.java.interfaces.ConexionMariaDB;
import com.curso.java.interfaces.DAO;

public class UsuarioImplementacion implements DAO<Usuario, String[]>, ConexionMariaDB {
	private Connection conexion;

	private PreparedStatement psInsertar = null;
	private PreparedStatement psEliminar = null;
	private PreparedStatement psActualizar = null;
	private PreparedStatement psBuscar = null;
	private PreparedStatement psListar = null;

	private static final String queryInsertar   = "insert into usuarios (descripcion, clave, activo) values (?, AES_ENCRYPT(?, ?),?)";
	private static final String queryEliminar   = "delete from usuarios where descripcion = ?";
	private static final String queryActualizar = "update usuarios set clave = AES_ENCRYPT(?, ?), activo = ? where descripcion = ?";
	private static final String queryBuscar     = "select descripcion, AES_DECRYPT(clave,?) AS clave, activo from usuarios where descripcion= ? and clave = AES_ENCRYPT(?,?)";
	private static final String queryListar     = "select descripcion, AES_DECRYPT(clave,?) AS clave, activo from usuarios";

	private static final String KEY = "proyectoFinal02";	

	public UsuarioImplementacion() {
		setConexion(conectar());
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void insertar(Usuario usuario) {
		try {
			if ( null == psInsertar) {
				psInsertar = getConexion().prepareStatement(queryInsertar);
			}			
			psInsertar.setString(1, usuario.getDescripcion());
			psInsertar.setString(2, usuario.getClave());
			psInsertar.setString(3, KEY);
			psInsertar.setBoolean(4, usuario.getActivo());
			psInsertar.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void eliminar(Usuario usuario) {
		try {
			if (null == psEliminar) {
				psEliminar = getConexion().prepareStatement(queryEliminar);
			}
			psEliminar.setString(1, usuario.getDescripcion());
			psEliminar.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Usuario usuario) {
		try {
			if (null == psActualizar) {
				psActualizar = getConexion().prepareStatement(queryActualizar);
			}
			psActualizar.setString(1, usuario.getClave());
			psActualizar.setString(2, KEY);
			psActualizar.setBoolean(3, usuario.getActivo());
			psActualizar.setString(4, usuario.getDescripcion());
			psActualizar.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario buscarId(String[] credenciales) {
		Usuario aux = null;
		try {		
			if(credenciales.length != 2) {
				throw new Exception("DEBE ENVIAR DESCRIPCION Y CLAVE");
			}
				
			if (null == psBuscar) {
				psBuscar = getConexion().prepareStatement(queryBuscar);
			}
			psBuscar.setString(1, KEY);
			psBuscar.setString(2, credenciales[0]);
			psBuscar.setString(3, credenciales[1]);
			psBuscar.setString(4, KEY);
			ResultSet rs = psBuscar.executeQuery();
			if (rs.next()) {
				aux = new Usuario();
				aux.setDescripcion(rs.getString("descripcion"));
				aux.setClave(rs.getString("clave"));
				aux.setActivo(rs.getBoolean("activo"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<>();

		try {
			if (null == psListar) {
				psListar = getConexion().prepareStatement(queryListar);
			}
		psListar.setString(1, KEY);
		ResultSet rs = psListar.executeQuery();
		while (rs.next()) {
			Usuario aux = new Usuario();
			aux.setDescripcion(rs.getString("descripcion"));
			aux.setClave(rs.getString("clave"));
			aux.setActivo(rs.getBoolean("activo"));
			lista.add(aux);
		}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}
	
public static void main(String[] args) {
	UsuarioImplementacion imp = new UsuarioImplementacion();
	try {
		System.out.println(new FileInputStream("resources" + File.separator + "database.properties"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Usuario user1 = new Usuario("Pablo123@gmail.com", "Loager123", true);
		
		String[] credenciales = {user1.getDescripcion(),user1.getClave()};
		System.out.println(imp.buscarId(credenciales));
	} catch (Exception e) {
	
		e.printStackTrace();
	}

}
}

