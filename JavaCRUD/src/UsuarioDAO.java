package JavaCRUD.src;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static final String URL = "jdbc:sqlite:database.db";

    public static void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre_completo, edad, direccion, telefono, fotografia) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombreCompleto());
            pstmt.setInt(2, usuario.getEdad());
            pstmt.setString(3, usuario.getDireccion());
            pstmt.setString(4, usuario.getTelefono());
            pstmt.setString(5, usuario.getFotografia());
            pstmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    public static List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre_completo"),
                    rs.getInt("edad"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("fotografia")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuarios: " + e.getMessage());
        }
        return lista;
    }

    public static void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre_completo = ?, edad = ?, direccion = ?, telefono = ?, fotografia = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombreCompleto());
            pstmt.setInt(2, usuario.getEdad());
            pstmt.setString(3, usuario.getDireccion());
            pstmt.setString(4, usuario.getTelefono());
            pstmt.setString(5, usuario.getFotografia());
            pstmt.setInt(6, usuario.getId());
            pstmt.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public static void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}