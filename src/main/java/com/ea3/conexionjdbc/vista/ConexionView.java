package com.ea3.conexionjdbc.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConexionView extends JFrame {

    // Componentes de la interfaz
    private JTextField txtUrl;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    private JButton btnProbarConexion;

    private JTextArea txtResultado;

    // Constructor de la ventana
    public ConexionView() {

        setTitle("EA3 - Probador de conexión JDBC");
        setSize(550, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 15));
        panelPrincipal.setBorder(
                new EmptyBorder(20, 20, 20, 20)
        );

        // Título
        JLabel lblTitulo = new JLabel(
                "Configuración de conexión a base de datos",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 17));

        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de campos
        JPanel panelCampos = new JPanel(
                new GridLayout(3, 2, 10, 12)
        );

        panelCampos.add(new JLabel("URL de conexión:"));

        txtUrl = new JTextField("jdbc:sqlite:inventario.db");
        panelCampos.add(txtUrl);

        panelCampos.add(new JLabel("Usuario:"));

        txtUsuario = new JTextField();
        panelCampos.add(txtUsuario);

        panelCampos.add(new JLabel("Contraseña:"));

        txtContrasena = new JPasswordField();
        panelCampos.add(txtContrasena);

        // Panel central
        JPanel panelCentral = new JPanel(
                new BorderLayout(10, 15)
        );

        panelCentral.add(panelCampos, BorderLayout.NORTH);

        // Botón de conexión
        btnProbarConexion = new JButton("Probar conexión");

        JPanel panelBoton = new JPanel(
                new FlowLayout(FlowLayout.CENTER)
        );

        panelBoton.add(btnProbarConexion);

        panelCentral.add(panelBoton, BorderLayout.CENTER);

        // Área de resultados
        txtResultado = new JTextArea(6, 30);
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        txtResultado.setFont(
                new Font("Monospaced", Font.PLAIN, 12)
        );

        JScrollPane scrollResultado = new JScrollPane(
                txtResultado
        );

        // Panel de resultados
        JPanel panelResultado = new JPanel(
                new BorderLayout(5, 5)
        );

        panelResultado.add(
                new JLabel("Resultado de la conexión:"),
                BorderLayout.NORTH
        );

        panelResultado.add(
                scrollResultado,
                BorderLayout.CENTER
        );

        panelResultado.setPreferredSize(
                new Dimension(500, 155)
        );

        panelCentral.add(panelResultado, BorderLayout.SOUTH);

        // Agregar panel central a la ventana
        panelPrincipal.add(
                panelCentral,
                BorderLayout.CENTER
        );
        add(panelPrincipal);
    }

    // Obtener URL
    public String getUrl() {
        return txtUrl.getText().trim();
    }

    // Obtener usuario
    public String getUsuario() {
        return txtUsuario.getText().trim();
    }

    // Obtener contraseña
    public char[] getContrasena() {
        return txtContrasena.getPassword();
    }

    // Obtener botón
    public JButton getBtnProbarConexion() {
        return btnProbarConexion;
    }

    // Mostrar resultados
    public void mostrarResultado(String mensaje, Color color) {

        txtResultado.setForeground(color);
        txtResultado.setText(mensaje);
    }
}
