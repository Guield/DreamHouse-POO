<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<h2>Lista de Empleados</h2>
<a href="${pageContext.request.contextPath}/empleado?action=new">Agregar Nuevo Empleado</a>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Primer Nombre</th>
        <th>Primer Apellido</th>
        <th>Correo Electrónico</th>
        <th>Fecha de Nacimiento</th>
        <th>Sucursal</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="empleado" items="${empleados}">
        <tr>
            <td>${empleado.idEmpleado}</td>
            <td>${empleado.primerNombre}</td>
            <td>${empleado.primerApellido}</td>
            <td>${empleado.email}</td>
            <td>${empleado.fechaNacimiento}</td>
            <td>${empleado.sucursal.direccionCalle} - ${empleado.sucursal.ciudad}</td>
            <td>
                <a href="${pageContext.request.contextPath}/empleado?action=edit&id=${empleado.idEmpleado}">Editar</a>
                <form action="${pageContext.request.contextPath}/empleado" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">
                    <button type="submit" onclick="return confirm('¿Estás seguro de que deseas eliminar este empleado?');">Eliminar</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>