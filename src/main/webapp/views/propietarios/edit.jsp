<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Propietario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css">
</head>
<body>
<h2>Editar Propietario</h2>

<form action="${pageContext.request.contextPath}/propietario" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="idPropietario" value="${propietario.idPropietario}"/>

    <label for="primerNombre">Primer Nombre:</label>
    <input type="text" id="primerNombre" name="primerNombre" value="${propietario.primerNombre}" required/><br><br>

    <label for="segundoNombre">Segundo Nombre:</label>
    <input type="text" id="segundoNombre" name="segundoNombre" value="${propietario.segundoNombre}"/><br><br>

    <label for="primerApellido">Primer Apellido:</label>
    <input type="text" id="primerApellido" name="primerApellido" value="${propietario.primerApellido}" required/><br><br>

    <label for="segundoApellido">Segundo Apellido:</label>
    <input type="text" id="segundoApellido" name="segundoApellido" value="${propietario.segundoApellido}"/><br><br>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" value="${propietario.direccion}" required/><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${propietario.email}" required/><br><br>

    <label for="telefono">Teléfono:</label>
    <input type="text" id="telefono" name="telefono" value="${propietario.telefono}" required/><br><br>

    <input type="submit" value="Actualizar Propietario"/>
</form>

<br>
<a href="${pageContext.request.contextPath}/propietario?action=list">Volver a la Lista de Propietarios</a>

<c:if test="${not empty error}">
    <div style="color: red;">
        <p>${error}</p>
    </div>
</c:if>
</body>
</html>