
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Contacto;
import util.ConexionDB;

public class ContactoDAO {
    public void agregarContacto(Contacto contactos) {
        String sql = "INSERT INTO contactos (nombre, apellido, email, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        //bloque try-with-resources
        //asegura que los recursos abiertos en su declaración (dentro de los paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contactos.getNombre());
            pstmt.setString(2, contactos.getApellido());
            pstmt.setString(3, contactos.getEmail());
            pstmt.setString(4, contactos.getDireccion());
             pstmt.setString(5, contactos.getTelefono());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contacto obtenerPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        Contacto contactos = new Contacto();
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
              
                contactos.setId(rs.getInt("id"));
                contactos.setNombre(rs.getString("nombre"));
                contactos.setApellido(rs.getString("apellido"));
                contactos.setEmail(rs.getString("email"));
                contactos.setDireccion(rs.getString("direccion"));
                 contactos.setTelefono(rs.getString("telefono"));
                return contactos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    public List<Contacto> obtenerTodos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setId(rs.getInt("id"));
                contacto.setNombre(rs.getString("nombre"));
                contacto.setApellido(rs.getString("apellido"));
                contacto.setEmail(rs.getString("email"));
                contacto.setDireccion(rs.getString("direccion"));
                contacto.setTelefono(rs.getString("telefono"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    public void actualizarContacto(Contacto contactos) {
        String sql = "UPDATE contactos SET nombre = ?, apellido = ?, email = ?, direccion = ?, telefono = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contactos.getNombre());
            pstmt.setString(2, contactos.getApellido());
            pstmt.setString(3, contactos.getEmail());
            pstmt.setString(4, contactos.getDireccion());
            pstmt.setString(5, contactos.getTelefono());
            pstmt.setInt(6, contactos.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarContacto(int id) {
        String sql = "DELETE FROM contactos WHERE id= ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

