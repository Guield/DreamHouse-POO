package sv.edu.udb.service;

import sv.edu.udb.utils.Clonexion;
import sv.edu.udb.form.Sucursal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalService {
    private Clonexion clonexion;

    public SucursalService() {
        this.clonexion = new Clonexion();
    }

    public List<Sucursal> obtenerSucursales() {
        List<Sucursal> sucursales = new ArrayList<>();
        String sql = "SELECT id_sucursal, direccion_calle, direccion_colonia, ciudad, departamento, telefono FROM sucursales";

        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("id_sucursal"));
                sucursal.setDireccionCalle(rs.getString("direccion_calle"));
                sucursal.setDireccionColonia(rs.getString("direccion_colonia"));
                sucursal.setCiudad(rs.getString("ciudad"));
                sucursal.setDepartamento(rs.getString("departamento"));
                sucursal.setTelefono(rs.getString("telefono"));

                sucursales.add(sucursal);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener sucursales: " + e.getMessage());
            e.printStackTrace();
        }
        return sucursales;
    }

    public boolean agregarSucursal(Sucursal sucursal) {
        String sql = "INSERT INTO sucursales (direccion_calle, direccion_colonia, ciudad, departamento, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, sucursal.getDireccionCalle());
            ps.setString(2, sucursal.getDireccionColonia());
            ps.setString(3, sucursal.getCiudad());
            ps.setString(4, sucursal.getDepartamento());
            ps.setString(5, sucursal.getTelefono());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar sucursal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean editarSucursal(Sucursal sucursal) {
        String sql = "UPDATE sucursales SET direccion_calle = ?, direccion_colonia = ?, ciudad = ?, departamento = ?, telefono = ? WHERE id_sucursal = ?";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, sucursal.getDireccionCalle());
            ps.setString(2, sucursal.getDireccionColonia());
            ps.setString(3, sucursal.getCiudad());
            ps.setString(4, sucursal.getDepartamento());
            ps.setString(5, sucursal.getTelefono());
            ps.setInt(6, sucursal.getIdSucursal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al editar sucursal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarSucursal(int idSucursal) {
        String sql = "DELETE FROM sucursales WHERE id_sucursal = ?";
        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idSucursal);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar sucursal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Sucursal obtenerSucursalPorId(int idSucursal) {
        Sucursal sucursal = null;
        String sql = "SELECT id_sucursal, direccion_calle, direccion_colonia, ciudad, departamento, telefono FROM sucursales WHERE id_sucursal = ?";

        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idSucursal);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("id_sucursal"));
                sucursal.setDireccionCalle(rs.getString("direccion_calle"));
                sucursal.setDireccionColonia(rs.getString("direccion_colonia"));
                sucursal.setCiudad(rs.getString("ciudad"));
                sucursal.setDepartamento(rs.getString("departamento"));
                sucursal.setTelefono(rs.getString("telefono"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener sucursal por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return sucursal;
    }
}