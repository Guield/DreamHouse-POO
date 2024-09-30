package sv.edu.udb.service;

import sv.edu.udb.utils.Clonexion;
import sv.edu.udb.form.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    private Clonexion clonexion;

    public EmpleadoService() {
        this.clonexion = new Clonexion();
    }

    public List<Empleado> obtenerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT id_empleado, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, categoria_laboral, salario, email, fecha_nacimiento, edad  FROM empleados";

        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdSucursal(rs.getInt("id_sucursal"));
                empleado.setPrimerNombre(rs.getString("primer_nombre"));
                empleado.setSegundoNombre(rs.getString("segundo_nombre"));
                empleado.setPrimerApellido(rs.getString("primer_apellido"));
                empleado.setSegundoApellido(rs.getString("segundo_apellido"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setCategoriaLaboral(rs.getString("categoria_laboral"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setEmail(rs.getString("email"));
                empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                empleado.setEdad(rs.getInt("edad"));

                empleados.add(empleado);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener sucursales: " + e.getMessage());
            e.printStackTrace();
        }
        return empleados;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleados (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, categoria_laboral, salario, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, empleado.getPrimerNombre());
            ps.setString(2, empleado.getSegundoNombre());
            ps.setString(3, empleado.getPrimerApellido());
            ps.setString(4, empleado.getSegundoApellido());
            ps.setString(5, empleado.getDireccion());
            ps.setString(6, empleado.getCategoriaLaboral());
            ps.setDouble(7, empleado.getSalario());
            ps.setString(8, empleado.getEmail());
            ps.setDate(9, (Date) empleado.getFechaNacimiento());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean editarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleados SET primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, direccion = ?, categoria_laboral = ?, salario = ?, email = ?, fecha_nacimiento = ? WHERE id_empleado = ?";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, empleado.getPrimerNombre());
            ps.setString(2, empleado.getSegundoNombre());
            ps.setString(3, empleado.getPrimerApellido());
            ps.setString(4, empleado.getSegundoApellido());
            ps.setString(5, empleado.getDireccion());
            ps.setString(6, empleado.getCategoriaLaboral());
            ps.setDouble(7, empleado.getSalario());
            ps.setString(8, empleado.getEmail());
            ps.setDate(9, (Date) empleado.getFechaNacimiento());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al editar empleado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEmpleado(int idEmpleado) {
        String sql = "DELETE FROM empleados WHERE id_empleado = ?";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idEmpleado);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}