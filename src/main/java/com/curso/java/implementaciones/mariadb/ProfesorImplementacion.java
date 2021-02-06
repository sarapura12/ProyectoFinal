package com.curso.java.implementaciones.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.curso.java.entidades.Documento;
import com.curso.java.entidades.Profesor;
import com.curso.java.interfaces.ConexionMariaDB;
import com.curso.java.interfaces.DAO;

public class ProfesorImplementacion implements DAO<Profesor, Documento>, ConexionMariaDB {
	private Connection conexion;

	private PreparedStatement psInsertar = null;
	private PreparedStatement psEliminar = null;
	private PreparedStatement psActualizar = null;
	private PreparedStatement psBuscar = null;
	private PreparedStatement psListar = null;

	private static final String queryInsertar = "insert into profesores (tipoDocumento, numeroDocumento, descripcion,fechaNacimiento, activo) values (?,?,?,?,?)";
	private static final String queryEliminar = "delete from profesores where tipoDocumento = ? and numeroDocumento = ?";
	private static final String queryActualizar = "update profesores set descripcion = ?, fechaNacimiento=? , activo = ? where tipoDocumento = ? and numeroDocumento = ?";
	private static final String queryBuscar = "select tipoDocumento, numeroDocumento, descripcion,fechaNacimiento, activo, fechaCreacion from profesores where tipoDocumento = ? and numeroDocumento = ?";
	private static final String queryListar = "select tipoDocumento, numeroDocumento, descripcion,fechaNacimiento, activo, fechaCreacion from profesores";

	public ProfesorImplementacion() {
		setConexion(conectar());
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void insertar(Profesor profesor) {
		try {
			if (null == psInsertar) {
				psInsertar = getConexion().prepareStatement(queryInsertar);
			}
			psInsertar.setString(1, profesor.getDocumento().getTipo());
			psInsertar.setString(2, profesor.getDocumento().getNumero());
			psInsertar.setString(3, profesor.getDescripcion());
			psInsertar.setDate(4,
					java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(profesor.getFechaNacimiento())));
			psInsertar.setBoolean(5, profesor.getActivo());
			psInsertar.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(Profesor profesor) {
		try {
			if (null == psEliminar) {
				psEliminar = getConexion().prepareStatement(queryEliminar);
			}
			psEliminar.setString(1, profesor.getDocumento().getNumero());
			psEliminar.setString(2, profesor.getDocumento().getTipo());
			psEliminar.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar(Profesor profesor) {

		try {
			if (null == psActualizar) {
				psActualizar = getConexion().prepareStatement(queryActualizar);
			}
			psActualizar.setString(1, profesor.getDescripcion());
			psActualizar.setDate(2,
					java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(profesor.getFechaNacimiento())));
			psActualizar.setBoolean(3, profesor.getActivo());
			psActualizar.setString(4, profesor.getDocumento().getNumero());
			psActualizar.setString(5, profesor.getDocumento().getTipo());
			psActualizar.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Profesor buscarId(Documento documento) {
		Profesor aux = null;

		try {
			if (null == psBuscar) {
				psBuscar = getConexion().prepareStatement(queryBuscar);
			}
			psBuscar.setString(1, documento.getNumero());
			psBuscar.setString(2, documento.getTipo());
			ResultSet rs = psBuscar.executeQuery();

			if (rs.next()) {
				aux = new Profesor();
				aux.setDocumento(documento);
				aux.setDescripcion(rs.getString("descripcion"));
				aux.setFechaCreacion(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(rs.getString("fechaCreacion")));
				aux.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fechaNacimiento")));
				aux.setActivo(rs.getBoolean("activo"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public List<Profesor> listar() {
		List<Profesor> listaAux = new ArrayList<>();

		try {
			if (null == psListar) {
				psListar = getConexion().prepareStatement(queryListar);
			}
			ResultSet rs = psListar.executeQuery();
			while (rs.next()) {
				Profesor aux = new Profesor();
				aux.setDocumento(new Documento(rs.getString("tipoDocumento"), rs.getString("numeroDocumento")));
				aux.setDescripcion(rs.getString("descripcion"));
				aux.setFechaCreacion(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(rs.getString("fechaCreacion")));
				aux.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fechaNacimiento")));
				aux.setActivo(rs.getBoolean("activo"));
				listaAux.add(aux);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return listaAux;
	}	
	

}
