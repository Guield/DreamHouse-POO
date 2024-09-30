<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sv.edu.udb.form.Sucursal" %>
<%@ page import="sv.edu.udb.service.SucursalService" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Sucursales</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Lista de Sucursales</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID Sucursal</th>
        <th>Dirección Calle</th>
        <th>Dirección Colonia</th>
        <th>Ciudad</th>
        <th>Departamento</th>
        <th>Teléfono</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
        SucursalService sucursalService = new SucursalService();
        List<Sucursal> sucursales = sucursalService.obtenerSucursales();

        for (Sucursal sucursal : sucursales) {
    %>
    <tr>
        <td><%= sucursal.getIdSucursal() %></td>
        <td><%= sucursal.getDireccionCalle() %></td>
        <td><%= sucursal.getDireccionColonia() %></td>
        <td><%= sucursal.getCiudad() %></td>
        <td><%= sucursal.getDepartamento() %></td>
        <td><%= sucursal.getTelefono() %></td>
        <td>
            <a href="editarSucursal?id=<%= sucursal.getIdSucursal() %>">Editar</a>
            <a href="eliminarSucursal?id=<%= sucursal.getIdSucursal() %>" onclick="return confirm('¿Estás seguro de eliminar esta sucursal?');">Eliminar</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<br>
<a href="nuevaSucursal">Nueva Sucursal</a>
</body>
</html>