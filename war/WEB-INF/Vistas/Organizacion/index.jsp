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
			<li><a href="/organizaciones/add">Registrar Organizacion</a></li>
		</ul>
	</div>

	<div class="container">
		

		<h4 class="titulo">REGISTRO DE ORGANIZACIONES</h4>
		<div class="table-responsive">
			<table class="table table-hover table-condensed">
				<tr>
				<th>Id de la Organizacion</th>
					<th>Nombre de la Organizacion</th>
					<th>Gmail de Administrador</th>
				</tr>
				<% 
					List<Organizacion> array = (List<Organizacion>)request.getAttribute("array");
				
					if(array!=null && array.size() > 0) {
						
						for(Organizacion organizacion:array){
				%>
				<tr>
					<td><%= organizacion.getId() %></td>
					<td><%= organizacion.getNombre() %></td>
					<td><%= organizacion.getEmail() %></td>
				</tr>
				<% }
				} %>

			</table>
			<div class="text-center">
				<a href="/organizaciones" class="btn btn-primary btn-block">ACTUALIZAR</a> <br>
			</div>

	
	</div>
	</div>
	<br>
</html>