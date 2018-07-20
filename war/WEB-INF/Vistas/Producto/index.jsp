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
			<li><a href="/productos/add">Agregar Producto</a></li>
		</ul>
	</div>

	<div class="container">


		<h4 class="titulo">REGISTRO DE PRODUCTOS</h4>
		<div class="table-responsive">
			<table class="table table-hover table-condensed">
				<tr>
					<th>Id-Producto</th>
					<th>Nombre</th>
					<th>Unidad</th>
					<th>Precio</th>
					<th>Estado</th>
				</tr>
				<% 
					List<Producto> array = (List<Producto>)request.getAttribute("array");
				
					if(array!=null && array.size() > 0) {
						
						for(Producto producto:array){
				%>
				<tr>
					<td><%= producto.getId() %></td>
					<td><%= producto.getNombre() %></td>
					<td><%= producto.getUnidad() %></td>
					<td><%= producto.getPrecio() %></td>
					<td><%= producto.estadoDespripcion() %></td>
				</tr>
				<% }
				} %>

			</table>
			<div class="text-center">
				<a href="/productos" class="btn btn-primary btn-block">ACTUALIZAR</a> <br>
			</div>

		</div>
	</div>
	<br>
</html>