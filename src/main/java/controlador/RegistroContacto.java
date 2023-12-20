
package controlador;

import dao.ContactoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Contacto;


@WebServlet(name = "RegistroContacto", urlPatterns = {"/RegistroContacto"})
public class RegistroContacto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        // Crear un objeto Orador con los datos
        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setEmail(email);
        contacto.setDireccion(direccion);
        contacto.setTelefono(telefono);

        // Obtener la fecha actual
        //java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        //orador.setFechaAlta(new Date(fechaActual.getTime()));

        // Agregar el orador a la base de datos
        ContactoDAO contactoDAO = new ContactoDAO();
        contactoDAO.agregarContacto(contacto);

        // Redireccionar a la página de visualización de oradores
       response.sendRedirect(request.getContextPath() + "gestionAgenda.jsp");

    }
}

    

