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
			<li><a href="/boletas/add">Agregar Boleta</a></li>
		</ul>
	</div>

	<div class="container">


		<h4 class="titulo">LISTA DE BOLETAS GENERADAS</h4>
		<div class="table-responsive">
			<table class="table table-hover table-condensed">
				<tr>
					<th>Id Boleta</th>
					<th>Producto</th>
					<th>Precio</th>
					<th>DNI</th>
					<th>Razon Social</th>
					<th>Direccion</th>
					<th>Cantidad</th>
					<th>Total</th>

				</tr>
				<% 
					List<Boleta> array = (List<Boleta>)request.getAttribute("array");
				List<Producto> array2 = (List<Producto>)request.getAttribute("array2");
					
				if(array!=null && array.size() > 0) 
				{
						int i = 0;
						Producto producto;
						for(Boleta boleta:array){
							producto = array2.get(i);
				%>
				<tr>
					<td><%= boleta.getId() %></td>
					<td><%=  producto.getNombre()%></td>
					<td><%=  producto.getPrecio()%></td>
					<td><%= boleta.getDni()%></td>
					<td><%= boleta.getRazonSocial() %></td>
					<td><%= boleta.getDireccion() %></td>
					<td><%= boleta.getCantidad() %></td>
					<td><%= boleta.getTotal()%></td>
				</tr>
				<% i++;}
				} %>

			</table>
			<div class="text-center">
				<a href="/boletas" class="btn btn-primary btn-block">ACTUALIZAR</a> <br>
			</div>


		</div>
	</div>
	<br>
</html>