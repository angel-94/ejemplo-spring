<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Personas</title>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.css">
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	</head>
	<body>
		<nav class="navbar navbar-default" role="navigation">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#"></a>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="navbar">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">Home</a></li>
		        <li><a href="#"></a></li>

		      </ul>
		      <form class="navbar-form navbar-left" role="search">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Search">
		        </div>
		        <button type="submit" class="btn btn-default">Submit</button>
		      </form>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#"></a></li>

		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<div class="container container-fluid">
			<div class="center-block">
				<h2>
					A&ntilde;adir a una persona.
				</h2>
			</div>
			<hr color="black">
			<c:url var="addAction" value="/persona/add"></c:url>
			<form:form action="${addAction}" commandName="person">  <!-- Command name tiene el nombre de la pagina --> <!-- Donde esta el bean que lo declara?? -->
					<!-- ID de la persona -->
					<c:if test="${!empty person.nombre}">  <!-- person de commandName -->
					    <form:label path="personaID">
					        <spring:message text="personaID" />
					    </form:label>
					    <form:input path="personaID" readonly="true" size="8" disabled="true"/>  <!-- Id de la persona en caso de editar -->
					    <form:hidden path="personaID" />
					</c:if>
					<!-- Nombre de la persona -->
					<form:label path="nombre">
					    <spring:message text="Nombre" />
					</form:label>
					<form:input path="nombre" placeholder="Nombre"/>
					<!-- País de la persona -->
					<form:label path="pais">
					    <spring:message text="Pais" />
					</form:label>
					<form:input path="pais" placeholder="Pais"/>


					<!-- País de la persona -->
					<form:label path="telefono">
							<spring:message text="Telefono" />
					</form:label>
					<form:input path="telefono" placeholder="Telefono"/>
					<!-- País de la persona -->
					<form:label path="direccion">
					    <spring:message text="Direccion" />
					</form:label>
					<form:input path="direccion" placeholder="Direccion"/>
					<!-- País de la persona -->
					<form:label path="correo">
					    <spring:message text="Correo" />
					</form:label>
					<form:input path="correo" placeholder="Correo"/>



					<!-- Si el campo del nombre no esta vacio aparece el boton editar -->
					<c:if test="${!empty person.nombre}">			<!-- person de commandName -->
					    <input type="submit" value="<spring:message text=" Editar "/>"/>
					</c:if>
					<!-- Si el campo del nombre esta vacio aparece el boton añadir -->
					<c:if test="${empty person.nombre}">				<!-- person de commandName -->
					    <input type="submit" value="<spring:message text=" A&ntilde;adir "/>"/>
					</c:if>

			</form:form>
			<hr>
			<br>
			<h3>Listas de las personas de la tabla</h3>
			<c:if test="${!empty listaPersonas}">
			    <table class="table table-bordered">
			        <thead>
			            <th>PersonaID</th>
			            <th>Nombre</th>
			            <th>Ciudad</th>
									<th>Telefono</th>
			            <th>Direccion</th>
									<th>Correo</th>
			            <th>Editar</th>
			            <th>Eliminar</th>
			        </thead>
			        <tbody>
			            <c:forEach items="${listaPersonas}" var="persona">
			                <tr>
			                    <td>${persona.personaID}</td>
			                    <td>${persona.nombre}</td>
			                    <td>${persona.pais}</td>
													<td>${persona.telefono}</td>
			                    <td>${persona.direccion}</td>
			                    <td>${persona.correo}</td>
			                    <td>
															<a href="<c:url value='/edita/${persona.personaID}' />">Editar</a>
			                    </td>
			                    <td>
			                        <a href="<c:url value='/elimina/${persona.personaID}' />">Elimiar</a>
			                    </td>
			                </tr>
			            </c:forEach>
			        </tbody>
			    </table>
			</c:if>
		</div>
	</body>
</html>
