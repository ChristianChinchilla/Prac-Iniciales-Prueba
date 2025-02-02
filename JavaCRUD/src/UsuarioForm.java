package JavaCRUD.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioForm extends JFrame {
    private JTextField txtNombre, txtEdad, txtDireccion, txtTelefono;
    private JButton btnGuardar;

    public UsuarioForm() {
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        btnGuardar = new JButton("Guardar");
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario(0, txtNombre.getText(), Integer.parseInt(txtEdad.getText()), 
                                              txtDireccion.getText(), txtTelefono.getText(), null);
                UsuarioDAO.insertarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuario guardado exitosamente.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UsuarioForm();
    }
}
