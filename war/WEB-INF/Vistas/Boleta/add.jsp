<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="modelos.*"%>
<%@page import="java.util.List"%>
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
			<li><a href="/boletas">Lista de Boletas</a></li>
		</ul>
	</div>
	<%
	
	String idOrganizacion = (String)request.getAttribute("idOrganizacion");
	List<Producto> array = (List<Producto>)request.getAttribute("array"); %>

	<div class="container">
		<div class="row">
			<div class="col-sm-10 col-md-6">
			
				<h4>
					<b>Generar Boleta</b>
				</h4>
				<form id="form1" class="form-horizontal" action="/boletas/add"
					method="POST">

					<div class="form-group">

						<label class="text-info col-sm-2 control-label">RUC</label>
						<div class="col-sm-10">
							<input type="text" hidden name="idOrganizacion" value="<%=idOrganizacion%>">
							<input class="form-control" name="ruc" type="number" required="">
						</div>
					</div>
					<div class="form-group">

						<label class="text-info col-sm-2 control-label">DNI</label>
						<div class="col-sm-10">

							<input class="form-control" name="dni" type="number" required="">
						</div>
					</div>

					<div class="form-group">

						<label class="text-info col-sm-2 control-label">Razon
							Social</label>
						<div class="col-sm-10">

							<input class="form-control" name="razonSocial" type="text"
								required="">
						</div>
					</div>

					<div class="form-group">

						<label class="text-info col-sm-2 control-label">Direccion</label>
						<div class="col-sm-10">
							<input class="form-control" name="direccion" type="text"
								required="">
						</div>
					</div>

					<div class="form-group">
						<label class="text-info col-sm-2 control-label">Producto</label>
						<div class="col-sm-10">

							<select class="form-control" name="idProducto">
								<% for(Producto producto:array){ %>
								<option value="<%=producto.getId()%>"><%=producto.getNombre() %></option>
								<%} %>
							</select>
						</div>
					</div>
					<div class="form-group">

						<label class="text-info col-sm-2 control-label">Cantidad</label>
						<div class="col-sm-10">
							<input class="form-control" name="cantidad" type="number"
								required="">
						</div>
					</div>

					<div class="text-right">
						<button class="btn btn-primary btn-block" id="enviar" type="submit">Generar Boleta</button>
					</div>
				</form>
				\
			</div>
		</div>
	</div>
	<br>
</html>