<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name='viewport'
	content='width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0,minimun-scale=1.0'>

<link rel='stylesheet' href="/css/bootstrap.min.css">
<link rel='stylesheet' href="/css/estilo.css">
<script type="text/javascript" src="/js/jQuery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<style>

p {
	color: black;
	font-family: Verdana;
}

body {
	background-color: LightSteelBlue
}
</style>
</head>
<body>
<br>
	<div class="container">
		<ul>
			<li><a href="/index.html">Inicio</a></li>
			<li><a href="/organizaciones">Organizaciones</a></li>
		</ul>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-10 col-md-8">
				
				<h4>
					<b>Insertar Organizacion</b>
				</h4>
				<form id="form1" class="form-horizontal" action="/organizaciones/add"
					method="POST">
					<div class="form-group">
						<label class="text-info col-sm-2 control-label">Nombre</label>
						<div class="col-sm-10">
							<input class="form-control"
							autofocus
								name="nombre" type="text" required="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label text-info">Email</label>
						<div class="col-sm-10">
							<div class="input-group ">
								<div class="input-group-addon">@</div>
								<input class="form-control"
									 name="gmail"
									type="email" required>
							</div>
						</div>
					</div>
					<div class="text-right">
						<button class="btn btn-block btn-primary" id="enviar" type="submit">Registrarse</button>
					</div>
				</form>
				
			</div>
		</div>
	</div>
	<br>
</html>