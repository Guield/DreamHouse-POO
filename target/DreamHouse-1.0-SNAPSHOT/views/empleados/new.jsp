<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Empleado</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<h2>Nuevo Empleado</h2>

<form action="${pageContext.request.contextPath}/empleado" method="post">
    <input type="hidden" name="action" value="create">

    <label for="primerNombre">Primer Nombre:</label>
    <input type="text" id="primerNombre" name="primerNombre" required>

    <label for="segundoNombre">Segundo Nombre:</label>
    <input type="text" id="segundoNombre" name="segundoNombre">

    <label for="primerApellido">Primer Apellido:</label>
    <input type="text" id="primerApellido" name="primerApellido" required>

    <label for="segundoApellido">Segundo Apellido:</label>
    <input type="text" id="segundoApellido" name="segundoApellido" required>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" required>

    <label for="categoriaLaboral">Categoría Laboral:</label>
    <input type="text" id="categoriaLaboral" name="categoriaLaboral" required>

    <label for="salario">Salario:</label>
    <input type="number" id="salario" name="salario" step="0.01" required>

    <label for="email">Correo Electrónico:</label>
    <input type="email" id="email" name="email" required>

    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>

    <label for="idSucursal">Sucursal:</label>
    <select id="idSucursal" name="idSucursal" required>
        <c:forEach var="sucursal" items="${sucursales}">
            <option value="${sucursal.idSucursal}">${sucursal.direccionCalle} - ${sucursal.ciudad}</option>
        </c:forEach>
    </select>

    <button type="submit">Guardar</button>
    <a href="${pageContext.request.contextPath}/empleado?action=list">Cancelar</a>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>