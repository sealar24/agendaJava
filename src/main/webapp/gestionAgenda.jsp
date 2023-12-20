<%@page import="dao.ContactoDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Contacto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agenda</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!-- Formulario para agregar nuevos contactos -->
        <div class="container mt-3">
            <form action="RegistroContacto" method="post" class="mb-3">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" class="form-control" name="nombre">
                </div>
                <div class="form-group">
                    <label>Apellido:</label>
                    <input type="text" class="form-control" name="apellido">
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label>Direccion:</label>
                    <input type="text" class="form-control" name="direccion">
                </div>
                <div class="form-group">
                    <label>Telefono:</label>
                    <input type="number" class="form-control" name="telefono">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Agregar Contacto</button>
            </form>
            <br>
            <div class="container mt-5">
                <h2>Gestión de Agenda</h2>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ContactoDAO contactoDAO = new ContactoDAO();
                            List<Contacto> contactos = contactoDAO.obtenerTodos();

                            if (contactos != null && !contactos.isEmpty()) {
                                for (Contacto contacto : contactos) {
                        %>
                        <tr>
                            <td><%= contacto.getId()%></td>
                            <td><%= contacto.getNombre()%></td>
                            <td><%= contacto.getApellido()%></td>
                            <td><%= contacto.getEmail()%></td>
                            <td><%= contacto.getDireccion()%></td>
                            <td><%= contacto.getTelefono()%></td>
                            <td>
                                <div class="d-flex">
                                    <!-- Formulario para actualizar -->
                                    <form action="OperacionServlet" method="post" class="mr-2">
                                        <input type="hidden" name="accion" value="editar">
                                        <input type="hidden" name="id" value="<%= contacto.getId()%>">
                                        <button type="submit" class="btn btn-warning btn-block">Actualizar</button>
                                    </form>

                                    <!-- Formulario para eliminar -->
                                    <form action="OperacionServlet" method="post">
                                        <input type="hidden" name="accion" value="eliminar">
                                        <input type="hidden" name="id" value="<%= contacto.getId()%>">
                                        <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="6">No hay oradores registrados.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <a href="../" class="btn btn-success">Volver</a>   
            </div>
    </body>
</html>

