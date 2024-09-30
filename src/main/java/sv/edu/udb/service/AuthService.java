package sv.edu.udb.service;

import sv.edu.udb.utils.Clonexion;
import sv.edu.udb.form.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    private Clonexion clonexion;

    public AuthService() {
        this.clonexion = new Clonexion();
    }

    public Usuario autenticar(String username, String password) {
        Usuario usuario = null;
        String sql = "SELECT id_usuario, usuario, password, rol FROM usuarios WHERE usuario = ? AND password = ?";

        try (Connection conexion = clonexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("usuario"),
                            rs.getString("password"),
                            rs.getString("rol")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }
}