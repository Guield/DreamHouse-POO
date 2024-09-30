<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Sucursales</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css">
</head>
<body>
<div class="container">
    <h1>Lista de Sucursales</h1>
    <a href="${pageContext.request.contextPath}/sucursal?action=new"><button>Agregar Nueva Sucursal</button></a>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Dirección Calle</th>
            <th>Dirección Colonia</th>
            <th>Ciudad</th>
            <th>Departamento</th>
            <th>Teléfono</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sucursal" items="${sucursales}">
            <tr>
                <td>${sucursal.idSucursal}</td>
                <td>${sucursal.direccionCalle}</td>
                <td>${sucursal.direccionColonia}</td>
                <td>${sucursal.ciudad}</td>
                <td>${sucursal.departamento}</td>
                <td>${sucursal.telefono}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/sucursal?action=edit&id=${sucursal.idSucursal}"><button>Editar</button></a>
                    <a href="${pageContext.request.contextPath}/sucursal?action=delete&id=${sucursal.idSucursal}"><button>Eliminar</button></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>