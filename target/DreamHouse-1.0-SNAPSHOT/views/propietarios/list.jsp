<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Propietarios</title>
</head>
<body>
<h2>Lista de Propietarios</h2>

<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Primer Nombre</th>
        <th>Segundo Nombre</th>
        <th>Primer Apellido</th>
        <th>Segundo Apellido</th>
        <th>Dirección</th>
        <th>Email</th>
        <th>Teléfono</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="propietario" items="${propietarios}">
        <tr>
            <td>${propietario.idPropietario}</td>
            <td>${propietario.primerNombre}</td>
            <td>${propietario.segundoNombre}</td>
            <td>${propietario.primerApellido}</td>
            <td>${propietario.segundoApellido}</td>
            <td>${propietario.direccion}</td>
            <td>${propietario.email}</td>
            <td>${propietario.telefono}</td>
            <td>
                <a href="${pageContext.request.contextPath}/propietario?action=edit&id=${propietario.idPropietario}">Editar</a> |
                <a href="${pageContext.request.contextPath}/propietario?action=delete&id=${propietario.idPropietario}" onclick="return confirm('¿Está seguro de que desea eliminar este propietario?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/propietario?action=new">Agregar Nuevo Propietario</a>

<c:if test="${not empty error}">
    <div style="color: red;">
        <p>${error}</p>
    </div>
</c:if>
</body>
</html>