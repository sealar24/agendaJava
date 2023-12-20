<%@page import="modelo.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Actualizar</title>
    </head>
    <body>
        <h1>Actualizar</h1>
        <div class="container mt-3">
            <form action="OperacionServlet" method="post" class="mb-3">
                  <input type="hidden" name="accion" value="actualizar">
                  <input type="hidden" name="id" value="<%= ((Contacto) request.getAttribute("contactoAEditar")).getId() %>">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" class="form-control" name="nombre" value="<%= ((Contacto) request.getAttribute("contactoAEditar")).getNombre() %>">
                </div>
                <div class="form-group">
                    <label>Apellido:</label>
                    <input type="text" class="form-control" name="apellido" value="<%= ((Contacto) request.getAttribute("contactoAEditar")).getApellido() %>">
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" class="form-control" name="email" value="<%= ((Contacto) request.getAttribute("contactoAEditar")).getEmail() %>">
                </div>
                <div class="form-group">
                    <label>Direccion:</label>
                    <input type="text" class="form-control" name="direccion" value="<%= ((Contacto) request.getAttribute("contactoAEditar")).getDireccion() %>">
                </div>
                <div class="form-group">
                    <label>Telefono:</label>
                    <input type="number" class="form-control" name="telefono" value="<%= ((Contacto) request.getAttribute("contactoAEditar")).getTelefono() %>">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Actualizar Contacto</button>
            </form>
        </div>
    </body>
</html>
