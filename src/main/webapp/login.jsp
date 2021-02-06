<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="css/style.css">

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
<title>Login - ProyectoFinal</title>
</head>

<body>
	<div class="modal-dialog text-center">
		<div class="col-sm-12 main-section">
			<div class="modal-content border border-0">

				<form action="login" method="post">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-user"></i>
							</span>
						</div>
						<input type="email" name="descripcion" id="descripcion"
							placeholder="usuario@correo.com" required class="form-control">
					</div>

					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-unlock"></i>
							</span>
						</div>
						<input type="password" name="clave" id="clave"
							placeholder="contraseña"
						
							required class="form-control">
					</div>

					<div>
						<button type="submit" class="btn btn-primary">Ingresar</button>
						<button type="reset" class="btn btn-warning">Limpiar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>