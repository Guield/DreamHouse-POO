package sv.edu.udb.service;

import sv.edu.udb.utils.Clonexion;
import sv.edu.udb.form.Propietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietarioService {
    private Clonexion clonexion;

    public PropietarioService() {
        this.clonexion = new Clonexion();
    }

    public List<Propietario> obtenerPropietario() {
        List<Propietario> propietarios = new ArrayList<>();
        String sql = "SELECT id_propietario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, telefono, email, FROM propietarios";

        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Propietario propietario = new Propietario();
                propietario.setIdPropietario(rs.getInt("id_propietario"));
                propietario.setPrimerNombre(rs.getString("primer_nombre"));
                propietario.setSegundoNombre(rs.getString("segundo_nombre"));
                propietario.setPrimerApellido(rs.getString("primer_apellido"));
                propietario.setSegundoApellido(rs.getString("segundo_apellido"));
                propietario.setDireccion(rs.getString("direccion"));
                propietario.setTelefono(rs.getString("telefono"));
                propietario.setEmail(rs.getString("email"));

                propietarios.add(propietario);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener propietarios: " + e.getMessage());
            e.printStackTrace();
        }
        return propietarios;
    }

    public boolean agregarPropietario(Propietario propietario) {
        String sql = "INSERT INTO empleados (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, propietario.getPrimerNombre());
            ps.setString(2, propietario.getSegundoNombre());
            ps.setString(3, propietario.getPrimerApellido());
            ps.setString(4, propietario.getSegundoApellido());
            ps.setString(5, propietario.getDireccion());
            ps.setString(6, propietario.getTelefono());
            ps.setString(7, propietario.getEmail());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar propietario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean editarPropietario(Propietario propietario) {
        String sql = "UPDATE empleados SET primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, direccion = ?, telefono = ?, email = ? WHERE id_empleado = ?";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, propietario.getPrimerNombre());
            ps.setString(2, propietario.getSegundoNombre());
            ps.setString(3, propietario.getPrimerApellido());
            ps.setString(4, propietario.getSegundoApellido());
            ps.setString(5, propietario.getDireccion());
            ps.setString(6, propietario.getTelefono());
            ps.setString(7, propietario.getEmail());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al editar propietario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPropietario(int idPropietario) {
        String sql = "DELETE FROM propietarios WHERE id_propietario = ?";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idPropietario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar propietario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}