<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sv.edu.udb.form.Sucursal" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nueva Sucursal</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Crear Nueva Sucursal</h1>

<form action="guardarSucursal" method="post">
    <label for="direccionCalle">Dirección Calle:</label><br>
    <input type="text" id="direccionCalle" name="direccionCalle" required><br>

    <label for="direccionColonia">Dirección Colonia:</label><br>
    <input type="text" id="direccionColonia" name="direccionColonia" required><br>

    <label for="ciudad">Ciudad:</label><br>
    <input type="text" id="ciudad" name="ciudad" required><br>

    <label for="departamento">Departamento:</label><br>
    <input type="text" id="departamento" name="departamento" required><br>

    <label for="telefono">Teléfono:</label><br>
    <input type="text" id="telefono" name="telefono" required pattern="\d{8,15}" title="Teléfono debe tener entre 8 y 15 dígitos"><br>

    <input type="submit" value="Guardar">
    <a href="listadoSucursales">Cancelar</a>
</form>
</body>
</html>