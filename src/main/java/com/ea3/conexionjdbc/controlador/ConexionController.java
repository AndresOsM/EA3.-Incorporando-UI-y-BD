package com.ea3.conexionjdbc.controlador;

import com.ea3.conexionjdbc.modelo.ConexionBD;
import com.ea3.conexionjdbc.vista.ConexionView;

import java.awt.Color;
import java.sql.SQLException;

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

        // Obtener la URL ingresada en la interfaz
        String url = vista.getUrl();

        // Validar que la URL no esté vacía
        if (url.isEmpty()) {

            vista.mostrarResultado(
                    "ERROR: La URL de conexión no puede estar vacía.",
                    Color.RED
            );

            return;
        }

        // Intentar establecer la conexión
        try {

            modelo.probarConexion(url);

            vista.mostrarResultado(
                    "CONEXIÓN EXITOSA\n\n" +
                            "La conexión con la base de datos SQLite " +
                            "se estableció correctamente.",
                    new Color(0, 128, 0)
            );

        } catch (ClassNotFoundException e) {

            vista.mostrarResultado(
                    "ERROR: No se encontró el controlador JDBC.\n\n" +
                            "Detalle técnico: " + e.getMessage(),
                    Color.RED
            );

        } catch (SQLException e) {

            vista.mostrarResultado(
                    "FALLO DE CONEXIÓN\n\n" +
                            "No fue posible conectar con la base de datos.\n\n" +
                            "Detalle técnico: " + e.getMessage(),
                    Color.RED
            );
        }
    }
}