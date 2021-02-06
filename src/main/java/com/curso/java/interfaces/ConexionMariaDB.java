	package com.curso.java.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMariaDB {
	default Connection conectar() {
		Properties prop = new Properties();
		Connection conectar = null;		
		try {	
			Class.forName("org.mariadb.jdbc.Driver");
			prop.load(new FileInputStream("resources" + File.separator + "database.properties"));
			final String URL = prop.getProperty("db.url");
			final String USUARIO = prop.getProperty("db.user");
			final String CLAVE = prop.getProperty("db.pass");
			conectar = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conectar;
	}
}
