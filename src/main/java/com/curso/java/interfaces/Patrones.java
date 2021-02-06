package com.curso.java.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Patrones {
	
	static boolean esCorreo(String correo) throws Exception {
		Pattern patron = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))");
		Matcher comparacion = patron.matcher(correo);
		if(!comparacion.find()) {
			throw new Exception("No es un correo electronico");			
		}
		return true;
	}
	
	static boolean esContra(String clave) throws Exception {
		Pattern patron = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
		Matcher comparacion = patron.matcher(clave);
		if(!comparacion.find()) {
			throw new Exception("La contraseña debe tener al entre 8 y 16 caracteres, al menos un "
								+ "dígito, al menos una minúscula y al menos una mayúscula.");
		}
		return true;
	}
}
