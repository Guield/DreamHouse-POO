<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nueva Sucursal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css">
</head>
<body>
<div class="container">
    <h1>Agregar Nueva Sucursal</h1>

    <form action="${pageContext.request.contextPath}/sucursal" method="post">
        <input type="hidden" name="action" value="create">
        <label for="direccionCalle">Dirección Calle:</label>
        <input type="text" name="direccionCalle" required>

        <label for="direccionColonia">Dirección Colonia:</label>
        <input type="text" name="direccionColonia" required>

        <label for="ciudad">Ciudad:</label>
        <input type="text" name="ciudad" required>

        <label for="departamento">Departamento:</label>
        <input type="text" name="departamento" required>

        <label for="telefono">Teléfono:</label>
        <input type="text" name="telefono" required>

        <button type="submit">Agregar Sucursal</button>
    </form>

    <a href="${pageContext.request.contextPath}/sucursal?action=list"><button>Volver a la Lista</button></a>
</div>
</body>
</html>