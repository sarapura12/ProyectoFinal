package com.curso.java.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.java.entidades.Usuario;
import com.curso.java.implementaciones.mariadb.UsuarioImplementacion;


@WebServlet(name = "login", urlPatterns = "/login")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginControlador() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("descripcion");
		String clave = request.getParameter("clave");
		String[] credenciales = {descripcion,clave};
		Usuario aux = new UsuarioImplementacion().buscarId(credenciales);
		HttpSession sesion = null;
		if(null != aux) {
			sesion = request.getSession();
			sesion.setAttribute("usuario", aux);
			request.getRequestDispatcher("index.jsp").forward(request, response);;
		}else {
			request.setAttribute("CREDENCIALES", "Credenciales Incorrectas");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
