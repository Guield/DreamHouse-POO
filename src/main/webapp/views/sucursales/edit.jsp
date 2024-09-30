<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Sucursal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css">
</head>
<body>
<div class="container">
    <h1>Editar Sucursal</h1>

    <form action="${pageContext.request.contextPath}/sucursal" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="idSucursal" value="${sucursal.idSucursal}">

        <label for="direccionCalle">Dirección Calle:</label>
        <input type="text" name="direccionCalle" value="${sucursal.direccionCalle}" required>

        <label for="direccionColonia">Dirección Colonia:</label>
        <input type="text" name="direccionColonia" value="${sucursal.direccionColonia}" required>

        <label for="ciudad">Ciudad:</label>
        <input type="text" name="ciudad" value="${sucursal.ciudad}" required>

        <label for="departamento">Departamento:</label>
        <input type="text" name="departamento" value="${sucursal.departamento}" required>

        <label for="telefono">Teléfono:</label>
        <input type="text" name="telefono" value="${sucursal.telefono}" required>

        <button type="submit">Actualizar Sucursal</button>
    </form>

    <a href="${pageContext.request.contextPath}/sucursal?action=list"><button>Volver a la Lista</button></a>
</div>
</body>
</html>