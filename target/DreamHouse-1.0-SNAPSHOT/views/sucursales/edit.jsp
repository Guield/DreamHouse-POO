<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sv.edu.udb.form.Sucursal" %>
<%@ page import="sv.edu.udb.service.SucursalService" %>
<%
    int idSucursal = Integer.parseInt(request.getParameter("id"));
    SucursalService sucursalService = new SucursalService();
    Sucursal sucursal = sucursalService.obtenerSucursalPorId(idSucursal); // Asegúrate de tener este método en tu servicio
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Sucursal</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Editar Sucursal</h1>

<form action="actualizarSucursal" method="post">
    <input type="hidden" name="idSucursal" value="<%= sucursal.getIdSucursal() %>"> <!-- Campo oculto para el ID de la sucursal -->

    <label for="direccionCalle">Dirección Calle:</label><br>
    <input type="text" id="direccionCalle" name="direccionCalle" value="<%= sucursal.getDireccionCalle() %>" required><br>

    <label for="direccionColonia">Dirección Colonia:</label><br>
    <input type="text" id="direccionColonia" name="direccionColonia" value="<%= sucursal.getDireccionColonia() %>" required><br>

    <label for="ciudad">Ciudad:</label><br>
    <input type="text" id="ciudad" name="ciudad" value="<%= sucursal.getCiudad() %>" required><br>

    <label for="departamento">Departamento:</label><br>
    <input type="text" id="departamento" name="departamento" value="<%= sucursal.getDepartamento() %>" required><br>

    <label for="telefono">Teléfono:</label><br>
    <input type="text" id="telefono" name="telefono" value="<%= sucursal.getTelefono() %>" required pattern="\d{8,15}" title="Teléfono debe tener entre 8 y 15 dígitos"><br>

    <input type="submit" value="Actualizar">
    <a href="listadoSucursales">Cancelar</a>
</form>
</body>
</html>