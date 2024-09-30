<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<h2>Editar Empleado</h2>

<form action="${pageContext.request.contextPath}/empleado" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">

    <label for="primerNombre">Primer Nombre:</label>
    <input type="text" id="primerNombre" name="primerNombre" value="${empleado.primerNombre}" required>

    <label for="segundoNombre">Segundo Nombre:</label>
    <input type="text" id="segundoNombre" name="segundoNombre" value="${empleado.segundoNombre}">

    <label for="primerApellido">Primer Apellido:</label>
    <input type="text" id="primerApellido" name="primerApellido" value="${empleado.primerApellido}" required>

    <label for="segundoApellido">Segundo Apellido:</label>
    <input type="text" id="segundoApellido" name="segundoApellido" value="${empleado.segundoApellido}" required>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" value="${empleado.direccion}" required>

    <label for="categoriaLaboral">Categoría Laboral:</label>
    <input type="text" id="categoriaLaboral" name="categoriaLaboral" value="${empleado.categoriaLaboral}" required>

    <label for="salario">Salario:</label>
    <input type="number" id="salario" name="salario" step="0.01" value="${empleado.salario}" required>

    <label for="email">Correo Electrónico:</label>
    <input type="email" id="email" name="email" value="${empleado.email}" required>

    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="${empleado.fechaNacimiento}" required>

    <label for="idSucursal">Sucursal:</label>
    <select id="idSucursal" name="idSucursal" required>
        <c:forEach var="sucursal" items="${sucursales}">
            <option value="${sucursal.idSucursal}" <c:if test="${sucursal.idSucursal == empleado.idSucursal}">selected</c:if>>
                    ${sucursal.direccionCalle} - ${sucursal.ciudad}
            </option>
        </c:forEach>
    </select>

    <button type="submit">Guardar Cambios</button>
    <a href="${pageContext.request.contextPath}/empleado?action=list">Cancelar</a>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>