<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Proyecto</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="text/css" media="screen" href="main.css" />
<script src="main.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />
</head>

<body>
	<header class="jumbotron text-center" style="margin-bottom: 0">
		<h1>Proyecto java</h1>
		<h2>Clase 02</h2>
	</header>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav justify-contend-end">
				<li class="nav-item"><a class="nav-link" href="#">
						Profesores</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Usuario</a></li>
			</ul>
		</div>
		<div class="dropdown">
			<a style="color: bisque;" class="nav-link dropdown-toggle"
				data-toggle="dropdown" href="#"> Cerrar Sesion</a>
			<div class="dropdown-menu text-center">
				<a><img src="images/user.png" width="50px" height="50px" /></a> <br>
				<a>Octavio Robleto</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Salir</a>
			</div>
		</div>
	</nav>

	<div class="container" style="margin-top: 50px">
		<div style="float: right" class="row">
			<button class="btn btn-success"><i class="fas fa-user-plus"></i></button>
		</div>
		<br>
		<br>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Tipo Documento</th>
						<th>Numero Documento</th>
						<th>Descripcion</th>
						<th>Fecha Nacimiento</th>
						<th>Fecha Creacion</th>
						<th>Activo</th>
						<th>Accion</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>DNI</td>
						<td>95663</td>
						<td>Pablo Sarapura</td>
						<td>1963-25-5</td>
						<td>2020-12-1</td>
						<td>Activo</td>
						<td><a class="btn btn-warning" href="#"><i
								class="fas fa-edit"></i></a> <a class="btn btn-danger" href="#"><i
								class="fas fa-trash-alt"></i></a></td>
					</tr>
					<tr>
						<td>DNI</td>
						<td>95663</td>
						<td>ERNESTO</td>
						<td>1963-25-5</td>
						<td>2020-12-1</td>
						<td>Activo</td>
						<td>
							<a class="btn btn-warning" href="#"><i class="fas fa-edit"></i></a>
						    <a class="btn btn-danger" href="#"><i class="fas fa-trash-alt"></i></a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<footer class="jumbotron text-center" style="margin-bottom: 0">
		<h3>Contacto</h3>
	</footer>
</body>

</html>