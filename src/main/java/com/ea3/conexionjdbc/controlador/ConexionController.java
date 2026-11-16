package com.ea3.conexionjdbc.controlador;

import com.ea3.conexionjdbc.modelo.ConexionBD;
import com.ea3.conexionjdbc.vista.ConexionView;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;

public class ConexionController {

    // Referencias al Modelo y a la Vista
    private final ConexionBD modelo;
    private final ConexionView vista;

    // Constructor del controlador
    public ConexionController(ConexionBD modelo, ConexionView vista) {

        this.modelo = modelo;
        this.vista = vista;

        // Escuchar el evento del botón
        this.vista.getBtnProbarConexion()
                .addActionListener(e -> probarConexion());
    }

    // Método para gestionar la prueba de conexión
    private void probarConexion() {

        // 1. Obtener los datos ingresados en la interfaz
        String url = vista.getUrl();
        String usuario = vista.getUsuario();

        char[] passwordChars = vista.getContrasena();

        // 2. Validar que la URL no esté vacía
        if (url.isEmpty()) {

            Arrays.fill(passwordChars, '\0');

            vista.mostrarResultado(
                    "ERROR: La URL de conexión no puede estar vacía.",
                    Color.RED
            );

            return;
        }

        // 3. Convertir la contraseña para enviarla al modelo
        String password = new String(passwordChars);

        // Limpiar el arreglo original
        Arrays.fill(passwordChars, '\0');

        // 4. Intentar establecer la conexión
        try {

            String resultado = modelo.probarConexion(
                    url,
                    usuario,
                    password
            );

            // Mostrar resultado exitoso
            vista.mostrarResultado(
                    "CONEXIÓN EXITOSA\n\n" + resultado,
                    new Color(0, 128, 0)
            );

        } catch (ClassNotFoundException e) {

            // Error al encontrar el controlador JDBC
            vista.mostrarResultado(
                    "ERROR: No se encontró el controlador JDBC.\n\n"
                            + "Detalle técnico: " + e.getMessage(),
                    Color.RED
            );

        } catch (SQLException e) {

            // Error durante la conexión
            vista.mostrarResultado(
                    "FALLO DE CONEXIÓN\n\n"
                            + "No fue posible conectar con la base de datos.\n\n"
                            + "Detalle técnico: " + e.getMessage(),
                    Color.RED
            );
        }
    }
}