package controlador;

import dao.ContactoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Contacto;

@WebServlet(name = "OperacionServlet", urlPatterns = {"/OperacionServlet"})
public class OperacionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        int id = Integer.parseInt(request.getParameter("id"));
        ContactoDAO dao = new ContactoDAO();

        switch (accion) {
            case "eliminar":
                dao.eliminarContacto(id);
                response.sendRedirect("gestionAgenda.jsp");
                break;
            case "editar":
                Contacto contactoAEditar = dao.obtenerPorId(id);
                request.setAttribute("contactoAEditar", contactoAEditar);
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "actualizar":
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String email = request.getParameter("email");
                String direccion = request.getParameter("direccion");
                String telefono = request.getParameter("telefono");
                Contacto contacto = new Contacto(id,nombre, apellido, email, direccion, telefono);
                dao.actualizarContacto(contacto);
                response.sendRedirect("gestionAgenda.jsp");
                break;
           
        }
    }
}
