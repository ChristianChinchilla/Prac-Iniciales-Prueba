package JavaCRUD.src;

public class Main {
    public static void main(String[] args) {
        // Crear usuario de prueba
        Usuario usuario = new Usuario(0, "Juan Pérez", 25, "Calle 123", "555-1234", "foto.jpg");

        // Insertar usuario
        UsuarioDAO.insertarUsuario(usuario);

        // Obtener y mostrar usuarios
        System.out.println("Lista de usuarios:");
        for (Usuario u : UsuarioDAO.obtenerUsuarios()) {
            System.out.println(u.getId() + " - " + u.getNombreCompleto());
        }

        // Actualizar usuario
        usuario.setId(1); // ID del usuario a actualizar
        usuario.setNombreCompleto("Juan Pérez Modificado");
        UsuarioDAO.actualizarUsuario(usuario);

        // Eliminar usuario
        UsuarioDAO.eliminarUsuario(1);
    }
}
