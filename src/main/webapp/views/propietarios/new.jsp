<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Propietario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css">
</head>
<body>
<h2>Agregar Nuevo Propietario</h2>

<form action="${pageContext.request.contextPath}/propietario" method="post">
    <input type="hidden" name="action" value="create">

    <label for="primerNombre">Primer Nombre:</label>
    <input type="text" id="primerNombre" name="primerNombre" required><br><br>

    <label for="segundoNombre">Segundo Nombre:</label>
    <input type="text" id="segundoNombre" name="segundoNombre"><br><br>

    <label for="primerApellido">Primer Apellido:</label>
    <input type="text" id="primerApellido" name="primerApellido" required><br><br>

    <label for="segundoApellido">Segundo Apellido:</label>
    <input type="text" id="segundoApellido" name="segundoApellido"><br><br>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" required><br><br>

    <label for="email">Correo Electrónico:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="telefono">Teléfono:</label>
    <input type="tel" id="telefono" name="telefono" required><br><br>

    <input type="submit" value="Guardar">
</form>

<br>
<a href="${pageContext.request.contextPath}/propietario?action=list">Volver a la lista</a>

<c:if test="${not empty error}">
    <div style="color: red;">
        <p>${error}</p>
    </div>
</c:if>
</body>
</html>